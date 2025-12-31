package com.sales.savvy.dto;

import com.sales.savvy.enums.Category;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CartItemDTO {

    private Long productId;
    private String name;
    private String description;
    private Double price;        // ✅ FIXED
    private String image;
    private Integer quantity;
    private String category;   // ✅ OPTIONAL but recommended

    public CartItemDTO() {}

    public CartItemDTO(
            Long productId,
            String name,
            String description,
            Double price,
            String image,
            Integer quantity,
            String category
    ) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.category = category;
    }

    // getters & setters

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }   // ✅
    public void setPrice(Double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
