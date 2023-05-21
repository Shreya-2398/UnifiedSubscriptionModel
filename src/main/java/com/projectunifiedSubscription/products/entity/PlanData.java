package com.projectunifiedSubscription.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PlanData {

    private int id;

    private String name;

    private int price;

    private boolean paused;

    private PlanProduct[] products;


    public PlanData(int id, String name, int price, boolean paused, PlanProduct[] products) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.products = products;
    }

    public PlanData() {
    }
}

