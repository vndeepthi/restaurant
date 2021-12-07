package com.infosys.restaurant.model;

public class ItemListDTO {

    private String name;
    private double price;

    public ItemListDTO(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
