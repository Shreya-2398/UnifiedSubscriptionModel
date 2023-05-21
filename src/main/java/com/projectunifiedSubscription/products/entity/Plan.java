package com.projectunifiedSubscription.products.entity;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Builder
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private boolean paused;

    public Plan(int id, String name, int price, boolean paused) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.paused = paused;
    }

    public Plan() {
    }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public int getPrice() {
    //     return price;
    // }

    // public void setPrice(int price) {
    //     this.price = price;
    // }

    // public boolean isPaused() {
    //     return paused;
    // }

     public void setPaused(boolean paused) {
         this.paused = paused;
     }

    // @Override
    // public String toString() {
    //     return "Plan{" +
    //             "id=" + id +
    //             ", name='" + name + '\'' +
    //             ", price=" + price +
    //             ", paused=" + paused +
    //             '}';
    // }
}

