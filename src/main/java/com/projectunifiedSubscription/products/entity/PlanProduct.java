package com.projectunifiedSubscription.products.entity;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Builder
@Entity
@Table(name = "planProducts")
public class PlanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, updatable = false)
    private int planId;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int productId;

    // @ManyToOne
    // @JoinColumn(nullable = false)
    @Column(nullable = false)
    private int timePeriod;

    public PlanProduct(int id, int planId, int price, int productId, int timePeriod) {
        this.id = id;
        this.planId = planId;
        this.price = price;
        this.productId = productId;
        this.timePeriod = timePeriod;
    }

    public PlanProduct() {
    }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getPlanId() {
    //     return planId;
    // }

    // public void setPlanId(String planId) {
    //     this.planId = planId;
    // }

    // public int getPrice() {
    //     return price;
    // }

    // public void setPrice(int price) {
    //     this.price = price;
    // }

    // public int getProduct() {
    //     return productId;
    // }

    // public void setProduct(Product product) {
    //     this.productId = productId;
    // }

    // public Product getTimePeriod() {
    //     return timePeriod;
    // }

    // public void setTimePeriod(Product timePeriod) {
    //     this.timePeriod = timePeriod;
    // }

    // @Override
    // public String toString() {
    //     return "SubscriptionProducts{" +
    //             "id=" + id +
    //             ", planId=" + planId +
    //             ", price=" + price +
    //             ", product=" + productId +
    //             ", timePeriod=" + timePeriod +
    //             '}';
    // }
}
