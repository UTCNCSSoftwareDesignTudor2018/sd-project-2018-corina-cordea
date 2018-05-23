package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.SellerDto;
import sd.project.business.service.SellerService;
import sd.project.presentation.view.SellerView;

@Controller
public class SellerController {
	@Autowired
	SellerService sellerService;
	private SellerView sellerView;

	public SellerController(SellerView sellerView) {
		super();
		this.sellerView = sellerView;
		sellerView.setSaveDataButtonActionListener(new SaveDataButtonActionListener());
	}

	private class SaveDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {

			SellerDto sDto = new SellerDto.SellerDtoBuilder().sellerName(sellerView.getSellerNameTextField().getText()).
															sellerUsername(sellerView.getUsernameTextField().getText()).
															sellerPassword(sellerView.getPasswordTextField().getText()).create();
			sellerService.save(sDto);
			sellerView.getAccountFrame().dispose();
		}
	}

	public SellerView getSellerView() {
		return sellerView;
	}

	public void setSellerView(SellerView sellerView) {
		this.sellerView = sellerView;
	}

}
