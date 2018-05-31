package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Controller;

import sd.project.business.dto.OrderDto;
import sd.project.business.service.OrderService;
import sd.project.presentation.view.OrderView;

@Controller
public class OrderController {
	private OrderService orderService;
	private DefaultTableModel model;
	private DefaultTableModel modelClient;
	private int row;
	private int rowClient;
	private OrderView orderView;
	private int id;
	private int selectedRow;
	public OrderController(OrderView orderView) {
		super();
		this.orderView = orderView;
	}
	public void setListeners() {
		orderView.setOrdersTableListener(new OrderTableListSelectionListener());
		orderView.setClientOrdersTableListener(new ClientOrderTableListSelectionListener());
		orderView.setUpdateStatusActionListener(new UpdateStatusActionListener());
	}
	
	private class OrderTableListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				row = orderView.getOrders().getSelectedRow();
				if (row > -1) {
					selectedRow = row;
					id = Integer.parseInt(model.getValueAt(row, 0).toString());
					orderView.getOrderTextArea().setText(orderService.findById(id).toString());
					orderView.getStatusTextField().setText(orderService.findById(id).getOrderStatus());
					orderView.getOrderRowSelectionModel().clearSelection();
				}
			}
		}
	}
	private class ClientOrderTableListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				rowClient = orderView.getClientOrders().getSelectedRow();
				if (rowClient > -1) {
					int id = Integer.parseInt(modelClient.getValueAt(rowClient, 0).toString());
					orderView.getClientOrderTextArea().setText(orderService.findById(id).toString());
					orderView.getClientOrderRowSelectionModel().clearSelection();
				}
			}
		}
	}
	public void viewOrders() {
		orderView.viewOrders();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		model = orderView.getOrderTableModel();
		orderView.getOrders().setModel(model);
		List<OrderDto> orders = orderService.findOrders();
		for (OrderDto o : orders) {
			int id = o.getOrderId();
			Date date = o.getOrderDate();
			String status = o.getOrderStatus();
			float totalPrice = o.getOrderTotalPrice();
			model.addRow(new Object[] { id, dateFormat.format(date), status, totalPrice });
		}
		orderView.getViewOrdersFrame().setVisible(true);
	}
	
	public void viewClientOrders() {
		orderView.viewClientOrders();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		modelClient = orderView.getOrderTableModel();
		orderView.getClientOrders().setModel(modelClient);
		List<OrderDto> orders = orderService.findOrders();
		for (OrderDto o : orders) {
			int id = o.getOrderId();
			Date date = o.getOrderDate();
			String status = o.getOrderStatus();
			float totalPrice = o.getOrderTotalPrice();
			modelClient.addRow(new Object[] { id, dateFormat.format(date), status, totalPrice });
		}
		orderView.getViewClientOrdersFrame().setVisible(true);
	}
	
	private class UpdateStatusActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			OrderDto order = orderService.getOrderDto(orderService.findById(id));
			order.setOrderStatus(orderView.getStatusTextField().getText());
			orderService.updateOrder(order);
			model.setValueAt(orderView.getStatusTextField().getText(), selectedRow, 2);
			getModel().fireTableDataChanged();
			orderView.getClientOrders().repaint();
			orderView.getOrderTextArea().setText(orderService.findById(id).toString());
			orderView.getClientOrderRowSelectionModel().clearSelection();
		}	
	}
	public void repaintOrders() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		modelClient.setRowCount(0);
		orderView.getClientOrders().setModel(modelClient);
		List<OrderDto> orders = orderService.findOrders();
		for (OrderDto o : orders) {
			int id = o.getOrderId();
			Date date = o.getOrderDate();
			String status = o.getOrderStatus();
			float totalPrice = o.getOrderTotalPrice();
			modelClient.addRow(new Object[] { id, dateFormat.format(date), status, totalPrice });
		}
		orderView.getClientOrderTextArea().setText("");;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getRowClient() {
		return rowClient;
	}
	public void setRowClient(int rowClient) {
		this.rowClient = rowClient;
	}
	public OrderView getOrderView() {
		return orderView;
	}
	public void setOrderView(OrderView orderView) {
		this.orderView = orderView;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public DefaultTableModel getModelClient() {
		return modelClient;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public void setModelClient(DefaultTableModel modelClient) {
		this.modelClient = modelClient;
	}
	
}
