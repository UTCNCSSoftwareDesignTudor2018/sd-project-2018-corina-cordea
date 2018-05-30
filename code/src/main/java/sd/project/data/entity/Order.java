package sd.project.data.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	 @Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY )
	 @Column
	 private int orderId;
	 @Column
	 private Date orderDate;
	 @Column
	 private String orderStatus;
	 @Column
	 private float orderTotalPrice;
	 @Column
	 private String orderPaymentMethod;
	 @ManyToOne
	 @JoinColumn(name = "client_id")
	 private Client client;
	 @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "order_details", 
	        joinColumns = { @JoinColumn(name = "order_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "product_id") }
	    )
	private	List<Product> products;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public float getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(float orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public String getOrderPaymentMethod() {
		return orderPaymentMethod;
	}
	public void setOrderPaymentMethod(String orderPaymentMethod) {
		this.orderPaymentMethod = orderPaymentMethod;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderTotalPrice=" + orderTotalPrice + ", orderPaymentMethod=" + orderPaymentMethod + ", client="
				+ client + ", products=" + products + "]";
	}
	
}
