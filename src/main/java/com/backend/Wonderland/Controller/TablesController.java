package com.backend.Wonderland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.backend.Wonderland.Model.Tables;
import com.backend.Wonderland.Service.TablesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    private TablesService tablesService;

    private String validarTables(Tables tables) {  
        return "Sin validaciones aun";
    }

    @GetMapping
    public ResponseEntity<List<Tables>> listar() {
        List<Tables> tables  = tablesService.findAll();
        if (tables.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> buscar(@PathVariable Integer id) {
        try {
            Tables tables = tablesService.findById(id);
            return ResponseEntity.ok(tables);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tables tables) {
        try {
            Tables nuevo = tablesService.save(tables);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch ( Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tables> actualizar(@PathVariable Integer id, @RequestBody Tables tables) {
        try {
            Tables tab = tablesService.findById(id);
            tab.setId(id);
            tab.setTable_number(tables.getTable_number());
            tab.setStatus(tables.getStatus());
            tablesService.save(tab);
            return ResponseEntity.ok(tables);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            Tables tables = tablesService.findById(id);
            tablesService.delete(id); 
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un Table con ese ID");
        }
    }
    
}
