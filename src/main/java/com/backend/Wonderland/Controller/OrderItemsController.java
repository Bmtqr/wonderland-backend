package com.backend.Wonderland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.backend.Wonderland.Model.OrderItems;
import com.backend.Wonderland.Service.OrderItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemsController {
    
    @Autowired
    private OrderItemsService orderItemsService;

    private String validarOrderItems (OrderItems orderItems) {  
        return "Sin validaciones aun";
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItems>> listarPorOrden(@PathVariable Integer orderId) {
        List<OrderItems> items = orderItemsService.findByOrderId(orderId);
        return ResponseEntity.ok(items);
    }

    @GetMapping
    public ResponseEntity<List<OrderItems>> listar() {
        List<OrderItems> orderItems  = orderItemsService.findAll();
        if (orderItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItems> buscar(@PathVariable Integer id) {
        try {
            OrderItems orderItems = orderItemsService.findById(id);
            return ResponseEntity.ok(orderItems);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody OrderItems orderItems) {
        try {
            OrderItems nuevo = orderItemsService.save(orderItems);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch ( Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItems> actualizar(@PathVariable Integer id, @RequestBody OrderItems orderItems) {
        try {
            OrderItems oi = orderItemsService.findById(id);
            oi.setId(id);
            oi.setOrders(orderItems.getOrders());
            oi.setProducts(orderItems.getProducts());
            oi.setPrice(orderItems.getPrice());
            oi.setQuantity(orderItems.getQuantity());
            orderItemsService.save(oi);
            return ResponseEntity.ok(orderItems);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            OrderItems orderItems = orderItemsService.findById(id);
            orderItemsService.delete(id); 
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un Order-item con ese ID");
        }
    }

}
