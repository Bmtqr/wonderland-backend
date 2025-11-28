package com.backend.Wonderland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.backend.Wonderland.Model.Orders;
import com.backend.Wonderland.Service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    
    @Autowired
    private OrdersService ordersService;

    private String validarOrders (Orders orders) {  
        return "Sin validaciones aun";
    }

    @GetMapping
    public ResponseEntity<List<Orders>> listar() {
        List<Orders> orders  = ordersService.findAll();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> buscar(@PathVariable Integer id) {
        try {
            Orders orders = ordersService.findById(id);
            return ResponseEntity.ok(orders);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Orders orders) {
        try {
            Orders nuevo = ordersService.save(orders);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch ( Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> actualizar(@PathVariable Integer id, @RequestBody Orders orders) {
        try {
            Orders ord = ordersService.findById(id);
            ord.setId(id);
            ord.setTables(orders.getTables());
            ord.setPersons(orders.getPersons());
            ord.setTotal(orders.getTotal());
            ord.setDate(orders.getDate());
            ordersService.save(ord);
            return ResponseEntity.ok(orders);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            Orders orders = ordersService.findById(id);
            ordersService.delete(id); 
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un Orders con ese ID");
        }
    }

}
