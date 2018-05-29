package sd.project.business.dto;

public class CartProduct {
	private ProductDto product;
	private float quantity;
	
	public CartProduct(ProductDto product, float quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}	
}
