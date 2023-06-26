import java.util.Objects;

public class Product implements Comparable<Product> {
	private String productName;
	private String sellerName;
	private Double price;
	private int count;

	public Product() {
	}

	public Product(String sellerName, Double price, int count) {
		super();
		this.sellerName = sellerName;
		this.productName = productName;
		this.price = price;
		this.count = count;
	}

	public String getSellerName() {
		return sellerName;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String sellerName) {
		this.productName = productName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, price, sellerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return count == other.count && Objects.equals(price, other.price)
				&& Objects.equals(sellerName, other.sellerName);
	}

	@Override
	public String toString() {
		return "Product [sellerName=" + sellerName + ", price=" + price + ", count=" + count + "]";
	}

	@Override
	public int compareTo(Product o) {
		return this.count - o.count;
	}
}
