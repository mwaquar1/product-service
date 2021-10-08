package com.waquar.springcloud.productservice.dto;

import com.waquar.springcloud.productservice.model.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal originalPrice;
    private BigDecimal discountedPrice;

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        originalPrice = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
