package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.ClientDto;
import sd.project.business.service.ClientService;
import sd.project.presentation.view.ClientView;

@Controller
public class ClientController {
	@Autowired
	ClientService clientService;
	private ClientView clientView;

	public ClientController(ClientView clientView) {
		super();
		this.clientView = clientView;
		clientView.setSaveDataButtonActionListener(new SaveDataButtonActionListener());
	}

	private class SaveDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {

			ClientDto cDto = new ClientDto.ClientDtoBuilder().clientName(clientView.getClientNameTextField().getText()).
															clientEmail(clientView.getClientEmailTextField().getText()).
															clientAddress(clientView.getClientAddressTextField().getText()).
															clientCity(clientView.getClientCityTextField().getText()).
															clientPincode(clientView.getClientPincodeTextField().getText()).
															clientPhoneNumber(clientView.getClientPhoneNumberTextField().getText()).
															clientUsername(clientView.getUsernameTextField().getText()).
															clientPassword(clientView.getPasswordTextField().getText()).create();
			clientService.save(cDto);
			clientView.getAccountFrame().dispose();
		}
	}

	public ClientView getClientView() {
		return clientView;
	}

	public void setClientView(ClientView clientView) {
		this.clientView = clientView;
	}

}
