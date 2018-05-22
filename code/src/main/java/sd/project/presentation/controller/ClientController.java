package sd.project.presentation.controller;

import org.springframework.stereotype.Controller;

import sd.project.presentation.view.ClientView;

@Controller
public class ClientController {
	private ClientView clientView;

	public ClientController(ClientView clientView) {
		super();
		this.clientView = clientView;
	}

	public ClientView getClientView() {
		return clientView;
	}

	public void setClientView(ClientView clientView) {
		this.clientView = clientView;
	}

}
