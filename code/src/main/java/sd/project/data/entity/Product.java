package sd.project.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
	private float productPrice;
	@Column
	private float productQuantity;
	@Column
	private String productImage; 
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public float getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(float productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	@Override
	public String toString() {
		return " Product Id: " + productId + "\n Name: " + productName + "\n Price: " + productPrice
				+ "\n Quantity: " + productQuantity 
				+ "\n Seller Name:" + seller.getSellerName() + "\n Category: " + category.getCategoryName();
	}
	
}
