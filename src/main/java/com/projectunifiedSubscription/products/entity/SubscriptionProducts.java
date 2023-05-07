package com.projectunifiedSubscription.products.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "subscriptionProducts")
public class SubscriptionProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id", insertable = false, updatable = false)
    private String planId;

    @Column(nullable = false)
    private int price;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "timePeriod", nullable = false)
    private Product durationInMonths;

    public SubscriptionProducts(int id, String planId, int price, int productId, Product durationInMonths) {
        this.id = id;
        this.planId = planId;
        this.price = price;
        this.productId = productId;
        this.durationInMonths = durationInMonths;
    }

    public SubscriptionProducts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduct() {
        return productId;
    }

    public void setProduct(Product product) {
        this.productId = productId;
    }

    public Product getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Product durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "SubscriptionProducts{" +
                "id=" + id +
                ", planId=" + planId +
                ", price=" + price +
                ", product=" + productId +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}
