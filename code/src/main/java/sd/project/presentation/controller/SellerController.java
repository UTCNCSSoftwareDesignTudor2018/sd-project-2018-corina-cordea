package sd.project.presentation.controller;

import org.springframework.stereotype.Controller;

import sd.project.presentation.view.SellerView;

@Controller
public class SellerController {
	private SellerView sellerView;

	public SellerController(SellerView sellerView) {
		super();
		this.sellerView = sellerView;
	}

	public SellerView getSellerView() {
		return sellerView;
	}

	public void setSellerView(SellerView sellerView) {
		this.sellerView = sellerView;
	}
	
}
