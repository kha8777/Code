package entity;

import java.util.Objects;

public class Product {
	private String productID;
	private String productName;
	private String manufacture;
	private String description;
	private Supplier supplier;
	private double price;
	
	public Product() {
		super();
	}

	public Product(String productID) {
		super();
		this.productID = productID;
	}

	public Product(String productID, String productName, String manufacture, String description, Supplier supplier,
			double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.manufacture = manufacture;
		this.description = description;
		this.supplier = supplier;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", manufacture=" + manufacture
				+ ", description=" + description + ", supplier=" + supplier + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productID, other.productID);
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
