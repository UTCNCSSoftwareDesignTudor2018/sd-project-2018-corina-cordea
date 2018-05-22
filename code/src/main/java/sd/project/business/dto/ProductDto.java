package sd.project.business.dto;

import sd.project.data.entity.Category;
import sd.project.data.entity.Seller;

public class ProductDto {
	private int productId;
	private String productName;
	private float productPrice;
	private float productQuantity;
	private byte[] productImage;
	private Seller seller;
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

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
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

}
