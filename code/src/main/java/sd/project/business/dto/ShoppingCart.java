package sd.project.business.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ShoppingCart {
	private List<CartProduct> cart = new ArrayList<>();

	public List<CartProduct> getCart() {
		return cart;
	}

	public void setCart(List<CartProduct> cart) {
		this.cart = cart;
	}
	
	public void removeProduct(ProductDto product) {
		CartProduct cartProduct = new CartProduct(null,0);
		for(CartProduct p: cart) {
			if(p.getProduct().getProductName().equals(product.getProductName())) {
				cartProduct = p;
			}
		}
		cart.remove(cartProduct);
	}
	
	public float computeSum() {
		float sum = 0;
		for(CartProduct p: cart) {
			sum += p.getProduct().getProductPrice()*p.getQuantity();
		}
		return sum;
	}
}
