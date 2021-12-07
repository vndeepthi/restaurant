package com.infosys.restaurant.service;

import com.infosys.restaurant.entity.OrderItem;
import com.infosys.restaurant.entity.TableOrder;
import com.infosys.restaurant.exception.RestaurantServiceException;
import com.infosys.restaurant.model.OrderItemDTO;
import com.infosys.restaurant.model.TableOrderDTO;
import com.infosys.restaurant.repository.TableOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class TableOrderServiceImpl implements TableOrderService {

    @Autowired
    TableOrderRepository tableOrderRepository;

    Function<OrderItem, OrderItemDTO> toOrderItemDTO = orderItem -> new OrderItemDTO(orderItem.getId(), orderItem.getItem(), orderItem.getQuantity());
    Function<TableOrder, TableOrderDTO> toTableOrderDTO = tableOrder -> new TableOrderDTO(tableOrder.getId(), tableOrder.getOrderItems().stream().map(toOrderItemDTO).collect(toList()));

    Function<OrderItemDTO, OrderItem> toOrderItem = orderItemDTO -> new OrderItem(orderItemDTO.getId(), orderItemDTO.getItem(), orderItemDTO.getQuantity());
    Function<TableOrderDTO, TableOrder> toTableOrder = tableOrderDTO -> new TableOrder(tableOrderDTO.getId(), tableOrderDTO.getOrderItems().stream().map(toOrderItem).collect(toList()));

    public TableOrderDTO findTableOrder(final Integer tableNumber) throws RestaurantServiceException {
        return tableOrderRepository.findById(tableNumber)
                .map(toTableOrderDTO)
                .orElseThrow(() -> new RestaurantServiceException("Table not taken by any customer"));
    }

    public TableOrderDTO save(final TableOrderDTO tableOrderDTO) throws RestaurantServiceException {
        boolean tableTaken = tableOrderRepository.findById(tableOrderDTO.getId()).isPresent();
        if(!tableTaken){
            TableOrder tableOrder = toTableOrder.apply(tableOrderDTO);
            tableOrder.getOrderItems().forEach(oi -> oi.setTableOrder(tableOrder));
            return toTableOrderDTO.apply(tableOrderRepository.save(tableOrder));
        } else {
            throw new RestaurantServiceException("Order already placed for this table");
        }
    }
}
