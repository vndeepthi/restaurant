package com.infosys.restaurant.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TableOrderDTO {

    @NotNull
    @Max(value = 10)
    private Integer id;

    @NotEmpty
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
