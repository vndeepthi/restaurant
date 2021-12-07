package com.infosys.restaurant.model;

public class OrderItemDTO {

    private Integer id;

    private String item;

    private Integer quantity;

    public OrderItemDTO(Integer id, String item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
