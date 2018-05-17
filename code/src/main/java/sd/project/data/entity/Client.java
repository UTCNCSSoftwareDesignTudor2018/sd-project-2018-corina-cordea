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
	 @GeneratedValue( strategy = GenerationType.IDENTITY )
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
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientEmail=" + clientEmail
				+ ", clientAddress=" + clientAddress + ", clientCity=" + clientCity + ", clientPincode=" + clientPincode
				+ ", clientPhoneNumber=" + clientPhoneNumber + "]";
	}
	 
}
