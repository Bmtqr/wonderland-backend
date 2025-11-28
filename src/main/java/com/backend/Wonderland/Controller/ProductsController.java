package com.backend.Wonderland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.backend.Wonderland.Model.Products;
import com.backend.Wonderland.Service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    private String validarProducts (Products products) {  
        return "Sin validaciones aun";
    }

    @GetMapping
    public ResponseEntity<List<Products>> listar() {
        List<Products> products  = productsService.findAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> buscar(@PathVariable Integer id) {
        try {
            Products products = productsService.findById(id);
            return ResponseEntity.ok(products);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Products products) {
        try {
            Products nuevo = productsService.save(products);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch ( Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> actualizar(@PathVariable Integer id, @RequestBody Products products) {
        try {
            Products pro = productsService.findById(id);
            pro.setId(id);
            pro.setName(products.getName());
            pro.setPrice(products.getPrice());
            pro.setDescription(products.getDescription());
            pro.setCategory(products.getCategory());
            pro.setSales(products.getSales());
            pro.setImage_url(products.getImage_url());
            productsService.save(pro);
            return ResponseEntity.ok(products);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            Products products = productsService.findById(id);
            productsService.delete(id); 
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un Producto con ese ID");
        }
    }

}