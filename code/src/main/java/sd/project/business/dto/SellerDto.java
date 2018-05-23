package sd.project.business.dto;

import java.util.List;

import sd.project.data.entity.Product;

public class SellerDto {
	private int sellerId;
	private String sellerName;
	private String sellerUsername;
	private String sellerPassword;
	private List<Product> products;

	public SellerDto() {
		super();
	}

	public SellerDto(String sellerName, String sellerUsername, String sellerPassword, List<Product> products) {
		super();
		this.sellerName = sellerName;
		this.sellerUsername = sellerUsername;
		this.sellerPassword = sellerPassword;
		this.products = products;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public static class SellerDtoBuilder {

		private String sellerName;
		private String sellerUsername;
		private String sellerPassword;
		private List<Product> products;

		public SellerDtoBuilder sellerName(String sellerName) {
			this.sellerName = sellerName;
			return this;
		}

		public SellerDtoBuilder sellerUsername(String sellerUsername) {
			this.sellerUsername = sellerUsername;
			return this;
		}

		public SellerDtoBuilder sellerPassword(String sellerPassword) {
			this.sellerPassword = sellerPassword;
			return this;
		}

		public SellerDtoBuilder sellerProducts(List<Product> products) {
			this.products = products;
			return this;
		}

		public SellerDto create() {
			return new SellerDto(sellerName, sellerUsername, sellerPassword, products);
		}
	}
}
