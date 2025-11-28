package com.backend.Wonderland.Repository;

import com.backend.Wonderland.Model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository <OrderItems, Integer> {

    List<OrderItems> findByOrdersId(Integer orderId);
    
}
