package com.projectunifiedSubscription.products.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String company;
    private String description;
    private int  price;
    private int timePeriod;

    public ProductDto(int id, String name, String company, String description, int price, int timePeriod) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.description = description;
        this.price = price;
        this.timePeriod = timePeriod;
    }

    public ProductDto() {
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDurationInMonths() {
        return timePeriod;
    }

    public void setDurationInMonths(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", timePeriod=" + timePeriod +
                '}';
    }
}
