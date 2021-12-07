package com.infosys.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName="id")
    private TableOrder tableOrder;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public TableOrder getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(TableOrder tableOrder) {
        this.tableOrder = tableOrder;
    }

    public OrderItem() {
    }

    public OrderItem(Integer id, String item, Integer quantity) {
        this.id=id;
        this.item=item;
        this.quantity=quantity;
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
