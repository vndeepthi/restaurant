package com.infosys.restaurant.controller;

import com.infosys.restaurant.exception.RestaurantServiceException;
import com.infosys.restaurant.model.CheckOutDTO;
import com.infosys.restaurant.model.ItemListDTO;
import com.infosys.restaurant.model.OrderItemDTO;
import com.infosys.restaurant.model.TableOrderDTO;
import com.infosys.restaurant.service.TableOrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@RestController
@RequestMapping("tableOrder")
public class TableOrderController {

    @Autowired
    TableOrderService tableOrderService;

    static Log logger  = LogFactory.getLog(TableOrderController.class);

    final static Map<String, Double> menu = Map.ofEntries(
            entry("Pasta", 15.0), entry("Pizza", 14.0), entry("Fries", 5.0), entry("Falafel", 10.0), entry("Cola", 4.0));

    @GetMapping("/itemsList")
    public ResponseEntity<List<ItemListDTO>> itemsList() throws RestaurantServiceException {
        logger.info("getting all the items from the menu");
        final List<ItemListDTO> itemsList = new ArrayList<>();
        menu.forEach((m, v) -> itemsList.add(new ItemListDTO(m, v)));
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @GetMapping("/{tableNumber}")
    public ResponseEntity<TableOrderDTO> findOrder(@PathVariable("tableNumber") Integer tableNumber) throws RestaurantServiceException {
        logger.info("trying to place table order");
        return new ResponseEntity<>(tableOrderService.findTableOrder(tableNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TableOrderDTO> saveOrder(@RequestBody TableOrderDTO tableOrderDTO) throws RestaurantServiceException {
        logger.info("trying to place table order");
        TableOrderDTO orderDTO = tableOrderService.save(tableOrderDTO);
        logger.info("table order successfully placed");
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PostMapping("/{tableNumber}")
    public ResponseEntity<CheckOutDTO> checkOut(@PathVariable("tableNumber") Integer tableNumber) throws RestaurantServiceException {
        logger.info("trying to checkout table");
        TableOrderDTO orderDTO = tableOrderService.findTableOrder(tableNumber);
        logger.info("table order successfully placed");
        double billAmount = 0;
        for (OrderItemDTO orderItemDTO: orderDTO.getOrderItems()) {
            billAmount += orderItemDTO.getQuantity() * menu.get(orderItemDTO.getItem());
        }
        return new ResponseEntity<>(new CheckOutDTO(orderDTO, billAmount), HttpStatus.OK);
    }
}
