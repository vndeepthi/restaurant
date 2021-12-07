package com.infosys.restaurant.service;

import com.infosys.restaurant.exception.RestaurantServiceException;
import com.infosys.restaurant.model.TableOrderDTO;

public interface TableOrderService {

    public TableOrderDTO findTableOrder(Integer tableNumber) throws RestaurantServiceException;

    public TableOrderDTO save(TableOrderDTO tableOrderDTO) throws RestaurantServiceException;
}
