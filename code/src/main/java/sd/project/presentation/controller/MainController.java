package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.service.ClientService;
import sd.project.business.service.SellerService;
import sd.project.presentation.view.ClientView;
import sd.project.presentation.view.MainView;
import sd.project.presentation.view.ProductView;
import sd.project.presentation.view.SellerView;

@Controller
public class MainController {
	@Autowired
	ClientService clientService;
	@Autowired
	SellerService sellerService;
	@Autowired
	ClientView clientView;
	@Autowired
	ClientController clientController;
	@Autowired
	SellerView sellerView;
	@Autowired
	SellerController sellerController;
	@Autowired
	ProductView productView;
	@Autowired
	ProductController productController;
	private MainView mainView;
	private String user;
	private String password;
	
	public MainController(MainView mainView) {
		super();
		this.mainView = mainView;
		mainView.setContinueButtonActionListener(new ContinueButtonActionListener());
		mainView.setCreateAccountButtonActionListener(new CreateAccountButtonActionListener());
	}
	
	private class ContinueButtonActionListener implements ActionListener{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event){
				user = mainView.getUsernameTextField().getText();
				password = mainView.getPasswordField().getText();
					if(mainView.getClientButton().isSelected()) {
						try {
							String pass = clientService.findClient(user);
							if(pass.equals(password)) {
								clientView.getClientFrame().setVisible(true);
								clientController.setClientView(clientView); 
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(mainView.getFrame(),"Wrong username or password!");
						}
					}
					else if(mainView.getSellerButton().isSelected()) {
						try {
							String pass = sellerService.findSeller(user);
							if(pass.equals(password)) {
								productController.setProductView(productView);
								productController.displayProducts();
								sellerView.setSellerFrame(productView.getProductFrame());
								sellerView.getSellerFrame().setVisible(true);
								sellerController.setSellerView(sellerView);	
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(mainView.getFrame(),"Wrong username or password!");
						}
					}
				}
			}
		
	private class CreateAccountButtonActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
					if(mainView.getClientButton().isSelected()) {
						clientView.createAccount();
						clientController.setClientView(clientView);
					}
					else if(mainView.getSellerButton().isSelected()) {
						sellerView.createAccount();
						sellerController.setSellerView(sellerView);	
					}
				}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	
}

