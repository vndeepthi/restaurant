package com.infosys.restaurant.repository;

import com.infosys.restaurant.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableOrderRepository extends JpaRepository<TableOrder, Integer> {
    Optional<TableOrder> findById(Integer tableId);
}
