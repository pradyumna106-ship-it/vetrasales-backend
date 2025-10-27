package dto;

public class ProductDTO {
	private String productName;
	private String category;
	private String brand;
	private String description;
	private double price;
	private double discount;
	private double finalPrice;
	private int quantity;
	private double ratings;
	private String productImage;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productName, String category, String brand, String description, double price,
			double discount, double finalPrice, int quantity, double ratings, String productImage) {
		super();
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.finalPrice = finalPrice;
		this.quantity = quantity;
		this.ratings = ratings;
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", category=" + category + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + ", discount=" + discount + ", finalPrice="
				+ finalPrice + ", quantity=" + quantity + ", ratings=" + ratings + ", productImage=" + productImage
				+ "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

}
