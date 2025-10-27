package dto;

public class CreateProductDTO {
	private String productName;
	private String category;
	private String brand;
	private String description;
	private Double price;
	private Double discount;
	private String productImage;
	private Long adminId; // Link to Admin by ID

	public CreateProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateProductDTO(String productName, String category, String brand, String description, Double price,
			Double discount, String productImage, Long adminId) {
		super();
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.productImage = productImage;
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "CreateProductDTO [productName=" + productName + ", category=" + category + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + ", discount=" + discount + ", productImage=" + productImage + ", adminId=" + adminId + "]";
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

}
