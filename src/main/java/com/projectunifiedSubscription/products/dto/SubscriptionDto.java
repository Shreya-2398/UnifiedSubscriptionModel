package com.projectunifiedSubscription.products.dto;

import com.projectunifiedSubscription.products.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionDto {
    private int id;
    private String name;
    private int price;
    private Product[] products;

    public SubscriptionDto(int id, String name, int price, Product[] products) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.products = products;
    }

    public SubscriptionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", products='" + products + '\'' +
                '}';
    }
}

