package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.ProductDto;
import sd.project.business.dto.SellerDto;
import sd.project.business.service.OrderService;
import sd.project.business.service.ProductService;
import sd.project.business.service.SellerService;
import sd.project.presentation.view.OrderView;
import sd.project.presentation.view.SellerView;

@Controller
public class SellerController {
	@Autowired
	SellerService sellerService;
	private SellerView sellerView;
	@Autowired
	ProductController productController;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	SellerDto seller;

	public SellerController(SellerView sellerView) {
		super();
		this.sellerView = sellerView;
		sellerView.setSaveDataButtonActionListener(new SaveDataButtonActionListener());
		sellerView.setMenuItemAddProductActionListener(new MenuItemAddProductActionListener());
		sellerView.setAddImageActionListener(new AddImageActionListener());
		sellerView.setAddProductActionListener(new AddProductActionListener());
		sellerView.setMenuItemViewOrdersActionListener(new MenuItemViewOrdersActionListener());
	}

	private class SaveDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {

			SellerDto sDto = new SellerDto.SellerDtoBuilder().sellerName(sellerView.getSellerNameTextField().getText())
					.sellerUsername(sellerView.getUsernameTextField().getText())
					.sellerPassword(sellerView.getPasswordTextField().getText()).create();
			sellerService.save(sDto);
			sellerView.getAccountFrame().dispose();
		}
	}

	private class MenuItemAddProductActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			sellerView.addProduct();
			sellerView.getAddProductFrame().setVisible(true);
		}
	}

	public class AddImageActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = fileChooser.showOpenDialog(sellerView.getSellerFrame());
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				Path path = Paths.get(selectedFile.getAbsolutePath());
				sellerView.getProductImage().setIcon(new ImageIcon(path.toString()));
				sellerView.getProductImage().setToolTipText(path.toString());
			}
		}
	}

	public class AddProductActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ProductDto productDto = new ProductDto();
			productDto.setProductName(sellerView.getProductNameField().getText());
			productDto.setProductPrice(Float.parseFloat(sellerView.getProductPriceField().getText()));
			productDto.setProductQuantity(Float.parseFloat(sellerView.getProductQuantityField().getText()));
			if (productService.findCategoryByName(sellerView.getProductCategoryField().getText()) == null) {
				productService.addCategory(sellerView.getProductCategoryField().getText());
				productController.getProductView().getCategories().addItem(sellerView.getProductCategoryField().getText());
			}
			productDto.setCategory(productService.findCategoryByName(sellerView.getProductCategoryField().getText()));
			productDto.setProductImage(sellerView.getProductImage().getToolTipText());
			productDto.setSeller(sellerService.findById(seller.getSellerId()));
			productService.updateProduct(productDto);
			productController.repaintProducts();
			sellerView.getAddProductFrame().dispose();
		}
	}
	private class MenuItemViewOrdersActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			OrderView orderView = new OrderView();
			OrderController orderController = new OrderController(orderView);
			orderController.setOrderService(orderService);
			orderController.setListeners();
			orderController.viewOrders();
		}
	}
	
	public SellerView getSellerView() {
		return sellerView;
	}

	public void setSellerView(SellerView sellerView) {
		this.sellerView = sellerView;
	}

	public SellerDto getSeller() {
		return seller;
	}

	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}
}
