package com.projectunifiedSubscription.products.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePlanDto {
    private int id;
    private int price;

    public UpdatePlanDto(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public UpdatePlanDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UpdatePlanDto{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
