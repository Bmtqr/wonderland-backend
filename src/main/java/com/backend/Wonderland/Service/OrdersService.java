package com.backend.Wonderland.Service;

import com.backend.Wonderland.Model.Orders;
import com.backend.Wonderland.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Orders findById(Integer id) {
        return ordersRepository.findById(id).get();
    }

    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    public void delete(Integer id) {
        ordersRepository.deleteById(id);
    }

}
