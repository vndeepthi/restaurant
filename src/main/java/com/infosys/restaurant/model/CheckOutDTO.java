package com.infosys.restaurant.model;

public class CheckOutDTO {

    private TableOrderDTO tableOrderDTO;
    private double billAmount;

    public CheckOutDTO(TableOrderDTO tableOrderDTO, double billAmount) {
        this.tableOrderDTO = tableOrderDTO;
        this.billAmount = billAmount;
    }

    public TableOrderDTO getTableOrderDTO() {
        return tableOrderDTO;
    }

    public double getBillAmount() {
        return billAmount;
    }
}
