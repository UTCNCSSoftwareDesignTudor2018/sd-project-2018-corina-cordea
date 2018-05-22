package sd.project.business.dto;

import java.sql.Date;
import java.util.List;

import sd.project.data.entity.Client;
import sd.project.data.entity.Product;

public class OrderDto {
	private int orderId;
	private Date orderDate;
	private String orderStatus;
	private float orderTotalPrice;
	private String orderPaymentMethod;
	private Client client;
	private List<Product> products;

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
}
