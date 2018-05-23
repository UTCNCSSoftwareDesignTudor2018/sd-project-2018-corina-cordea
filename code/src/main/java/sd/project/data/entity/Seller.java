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
@Table(name = "sellers")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int sellerId;
	@Column
	private String sellerName;
	@Column
	private String sellerUsername;
	@Column
	private String sellerPassword;
	@OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
	private List<Product> products;

	public Seller() {
		super();
	}

	public Seller(String sellerName, String sellerUsername, String sellerPassword, List<Product> products) {
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

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + "]";
	}

	public static class SellerBuilder {

		private String sellerName;
		private String sellerUsername;
		private String sellerPassword;
		private List<Product> products;

		public SellerBuilder sellerName(String sellerName) {
			this.sellerName = sellerName;
			return this;
		}

		public SellerBuilder sellerUsername(String sellerUsername) {
			this.sellerUsername = sellerUsername;
			return this;
		}

		public SellerBuilder sellerPassword(String sellerPassword) {
			this.sellerPassword = sellerPassword;
			return this;
		}

		public SellerBuilder sellerProducts(List<Product> products) {
			this.products = products;
			return this;
		}

		public Seller create() {
			return new Seller(sellerName, sellerUsername, sellerPassword, products);
		}
	}
}
