package sd.project.business.dto;

import java.util.List;

import sd.project.data.entity.Order;

public class ClientDto {
	private int clientId;
	private String clientName;
	private String clientEmail;
	private String clientAddress;
	private String clientCity;
	private String clientPincode;
	private String clientPhoneNumber;
	private String clientUsername;
	private String clientPassword;
	private List<Order> orders;

	public ClientDto() {
		super();
	}

	public ClientDto(int clientId, String clientName, String clientEmail, String clientAddress, String clientCity,
			String clientPincode, String clientPhoneNumber, String clientUsername, String clientPassword,
			List<Order> orders) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientAddress = clientAddress;
		this.clientCity = clientCity;
		this.clientPincode = clientPincode;
		this.clientPhoneNumber = clientPhoneNumber;
		this.clientUsername = clientUsername;
		this.clientPassword = clientPassword;
		this.orders = orders;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientPincode() {
		return clientPincode;
	}

	public void setClientPincode(String clientPincode) {
		this.clientPincode = clientPincode;
	}

	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public static class ClientDtoBuilder {

		private int clientId;
		private String clientName;
		private String clientEmail;
		private String clientAddress;
		private String clientCity;
		private String clientPincode;
		private String clientPhoneNumber;
		private String clientUsername;
		private String clientPassword;
		private List<Order> orders;

		public ClientDtoBuilder clientId(int clientId) {
			this.clientId = clientId;
			return this;
		}
		
		public ClientDtoBuilder clientName(String clientName) {
			this.clientName = clientName;
			return this;
		}

		public ClientDtoBuilder clientEmail(String clientEmail) {
			this.clientEmail = clientEmail;
			return this;
		}

		public ClientDtoBuilder clientAddress(String clientAddress) {
			this.clientAddress = clientAddress;
			return this;
		}

		public ClientDtoBuilder clientCity(String clientCity) {
			this.clientCity = clientCity;
			return this;
		}

		public ClientDtoBuilder clientPincode(String clientPincode) {
			this.clientPincode = clientPincode;
			return this;
		}

		public ClientDtoBuilder clientPhoneNumber(String clientPhoneNumber) {
			this.clientPhoneNumber = clientPhoneNumber;
			return this;
		}

		public ClientDtoBuilder clientUsername(String clientUsername) {
			this.clientUsername = clientUsername;
			return this;
		}

		public ClientDtoBuilder clientPassword(String clientPassword) {
			this.clientPassword = clientPassword;
			return this;
		}

		public ClientDtoBuilder clientOrders(List<Order> orders) {
			this.orders = orders;
			return this;
		}

		public ClientDto create() {
			return new ClientDto(clientId, clientName, clientEmail, clientAddress, clientCity, clientPincode, clientPhoneNumber,
					clientUsername, clientPassword, orders);
		}

	}
}
