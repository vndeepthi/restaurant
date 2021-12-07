package com.infosys.restaurant.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "table_order")
public class TableOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableOrder")
    private List<OrderItem> orderItems;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public TableOrder() {
    }

    public TableOrder(Integer id, List<OrderItem> orderItems) {
        this.id= id;
        this.orderItems=orderItems;
    }
}
