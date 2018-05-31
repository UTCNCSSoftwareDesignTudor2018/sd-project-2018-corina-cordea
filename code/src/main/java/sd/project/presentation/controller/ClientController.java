package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.CartProduct;
import sd.project.business.dto.ClientDto;
import sd.project.business.dto.OrderDetailsDto;
import sd.project.business.dto.OrderDto;
import sd.project.business.dto.ProductDto;
import sd.project.business.dto.ShoppingCart;
import sd.project.business.service.ClientService;
import sd.project.business.service.OrderService;
import sd.project.business.service.ProductService;
import sd.project.presentation.view.ClientView;
import sd.project.presentation.view.OrderView;

@Controller
public class ClientController implements Observer{
	@Autowired
	ClientService clientService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	OrderController orderController;
	OrderView orderView;
	private ClientDto client;
	private ClientView clientView;
	private DefaultTableModel model;
	private float sum;
	private int row;

	public ClientController(ClientView clientView) {
		super();
		this.clientView = clientView;
		clientView.setSaveDataButtonActionListener(new SaveDataButtonActionListener());
		clientView.setMenuItemViewCartActionListener(new MenuItemViewCartActionListener());
		clientView.setTableListener(new TableListSelectionListener());
		clientView.setDeleteButtonActionListener(new DeleteActionListener());
		clientView.setOrderButtonActionListener(new OrderButtonActionListener());
		clientView.setConfirmButtonActionListener(new ConfirmButtonActionListener());
		clientView.setMenuItemViewOrdersActionListener(new MenuItemViewOrdersActionListener());
	}

	private class SaveDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {

			ClientDto cDto = new ClientDto.ClientDtoBuilder().clientName(clientView.getClientNameTextField().getText())
					.clientEmail(clientView.getClientEmailTextField().getText())
					.clientAddress(clientView.getClientAddressTextField().getText())
					.clientCity(clientView.getClientCityTextField().getText())
					.clientPincode(clientView.getClientPincodeTextField().getText())
					.clientPhoneNumber(clientView.getClientPhoneNumberTextField().getText())
					.clientUsername(clientView.getUsernameTextField().getText())
					.clientPassword(clientView.getPasswordTextField().getText()).create();
			clientService.save(cDto);
			clientView.getAccountFrame().dispose();
		}
	}

	private class MenuItemViewCartActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			List<CartProduct> products = clientView.getShoppingCart().getCart();
			clientView.viewCart();
			model = clientView.getProductTableModel();
			clientView.getProducts().setModel(model);
			for (CartProduct p : products) {
				String name = p.getProduct().getProductName();
				float quantity = p.getQuantity();
				model.addRow(new Object[] { name, quantity });
			}
			sum = clientView.getShoppingCart().computeSum();
			clientView.getTotalPriceSum().setText(String.valueOf(sum));
			clientView.getCartFrame().setVisible(true);
		}
	}

	private class TableListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				row = clientView.getProducts().getSelectedRow();
				if (row > -1) {
					clientView.getProductTextField().setText(model.getValueAt(row, 0).toString());
					clientView.getQuantityTextField().setText(model.getValueAt(row, 1).toString());
					clientView.getRowSelectionModel().clearSelection();
				}
			}
		}

	}

	private class DeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clientView.getShoppingCart().getCart().size()>0) {
			String name = clientView.getProductTextField().getText();
			float quantity = Float.parseFloat(clientView.getQuantityTextField().getText());
			ProductDto pDto = productService.findProductByName(name);
			clientView.getShoppingCart().removeProduct(pDto);
			pDto.setProductQuantity(pDto.getProductQuantity() + quantity);
			productService.updateProduct(pDto);
			sum = clientView.getShoppingCart().computeSum();
			model = clientView.getProductTableModel();
			clientView.getProducts().setModel(model);
			for (CartProduct p : clientView.getShoppingCart().getCart()) {
				String nameProduct = p.getProduct().getProductName();
				float quantityProduct = p.getQuantity();
				model.addRow(new Object[] { nameProduct, quantityProduct });
			}
			clientView.getTotalPriceSum().setText(String.valueOf(sum));
			clientView.getCartFrame().repaint();
			}
		}
	}
	private class OrderButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			clientView.placeOrder();
			clientView.getOrderFrame().setVisible(true);
		}
	}
	
	private class ConfirmButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			List<CartProduct> cart = clientView.getShoppingCart().getCart();
			if(cart.size()>0) {
			OrderDto order = new OrderDto();
			order.setClient(clientService.findById(client.getClientId()));
			order.setOrderDate(new Date());
			order.setOrderPaymentMethod(clientView.getGroup().getSelection().getActionCommand());
			order.setOrderStatus("");
			order.setOrderTotalPrice(sum);
			int orderId = orderService.save(order);
			for (CartProduct p : cart) {
				OrderDetailsDto orderDetails = new OrderDetailsDto();
				orderDetails.setProduct(productService.findById(p.getProduct().getProductId()));
				orderDetails.setOrder(orderService.findById(orderId));
				orderDetails.setQuantity(p.getQuantity());
				orderService.saveOrderDetails(orderDetails);
			}
			clientView.getOrderFrame().dispose();
			clientView.getCartFrame().dispose();
			clientView.setShoppingCart(new ShoppingCart());
			}
		}
	}
	private class MenuItemViewOrdersActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			orderView = new OrderView();
			orderController = new OrderController(orderView);
			orderController.setOrderService(orderService);
			orderController.setListeners();
			orderController.viewClientOrders(client.getClientId());
		}
	}
	public void addToList() {
		orderService.attach(this);
	}
	public ClientView getClientView() {
		return clientView;
	}
	public void setClientView(ClientView clientView) {
		this.clientView = clientView;
	}
	public ClientDto getClient() {
		return client;
	}
	public void setClient(ClientDto client) {
		this.client = client;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		orderController.repaintOrders(client.getClientId());
	}
}
