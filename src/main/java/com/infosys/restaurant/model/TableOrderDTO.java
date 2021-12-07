package com.infosys.restaurant.model;

import java.util.List;

public class TableOrderDTO {

    private Integer id;

    private List<OrderItemDTO> orderItems;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public TableOrderDTO(Integer id, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }
}
