package sd.project.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int clientId;
	@Column
	private String clientName;
	@Column
	private String clientEmail;
	@Column
	private String clientAddress;
	@Column
	private String clientCity;
	@Column
	private String clientPincode;
	@Column
	private String clientPhoneNumber;
	@Column
	private String clientUsername;
	@Column
	private String clientPassword;
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Order> orders;

	public Client() {
		super();
	}

	public Client(String clientName, String clientEmail, String clientAddress, String clientCity, String clientPincode,
			String clientPhoneNumber, String clientUsername, String clientPassword, List<Order> orders) {
		super();
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

	@Override
	public String toString() {
		return " Client Id: " + clientId + "\n Name: " + clientName + "\n Email: " + clientEmail
				+ "\n Address: " + clientAddress + "\n City: " + clientCity + "\n Pincode: " + clientPincode
				+ "\n Phone Number: " + clientPhoneNumber;
	}

	public static class ClientBuilder {

		private String clientName;
		private String clientEmail;
		private String clientAddress;
		private String clientCity;
		private String clientPincode;
		private String clientPhoneNumber;
		private String clientUsername;
		private String clientPassword;
		private List<Order> orders;

		public ClientBuilder clientName(String clientName) {
			this.clientName = clientName;
			return this;
		}

		public ClientBuilder clientEmail(String clientEmail) {
			this.clientEmail = clientEmail;
			return this;
		}

		public ClientBuilder clientAddress(String clientAddress) {
			this.clientAddress = clientAddress;
			return this;
		}

		public ClientBuilder clientCity(String clientCity) {
			this.clientCity = clientCity;
			return this;
		}

		public ClientBuilder clientPincode(String clientPincode) {
			this.clientPincode = clientPincode;
			return this;
		}

		public ClientBuilder clientPhoneNumber(String clientPhoneNumber) {
			this.clientPhoneNumber = clientPhoneNumber;
			return this;
		}

		public ClientBuilder clientUsername(String clientUsername) {
			this.clientUsername = clientUsername;
			return this;
		}

		public ClientBuilder clientPassword(String clientPassword) {
			this.clientPassword = clientPassword;
			return this;
		}

		public ClientBuilder clientOrders(List<Order> orders) {
			this.orders = orders;
			return this;
		}

		public Client create() {
			return new Client(clientName, clientEmail, clientAddress, clientCity, clientPincode, clientPhoneNumber,
					clientUsername, clientPassword, orders);
		}

	}
}
