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
	
}
