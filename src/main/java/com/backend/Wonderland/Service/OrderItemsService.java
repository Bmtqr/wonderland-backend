package com.backend.Wonderland.Service;

import com.backend.Wonderland.Model.OrderItems;
import com.backend.Wonderland.Repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;
    
    public List<OrderItems> findAll() {
        return orderItemsRepository.findAll();
    }

    public OrderItems findById(Integer id) {
        return orderItemsRepository.findById(id).get();
    }

    public OrderItems save(OrderItems orderitems) {
        return orderItemsRepository.save(orderitems);
    }

    public void delete(Integer id) {
        orderItemsRepository.deleteById(id);
    }

    public List<OrderItems> findByOrderId(Integer orderId) {
        return orderItemsRepository.findByOrdersId(orderId);
    }
    
}
