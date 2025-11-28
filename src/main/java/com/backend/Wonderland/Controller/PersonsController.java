package com.backend.Wonderland.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.backend.Wonderland.Model.Persons;
import com.backend.Wonderland.Service.PersonsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    @Autowired
    private PersonsService personsService;

    private String validarPersons(Persons persons) {
        return "Sin validaciones aun";
    }

    @GetMapping
    public ResponseEntity<List<Persons>> listar() {
        List<Persons> persons = personsService.findAll();
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Persons> buscar(@PathVariable Integer rut) {
        try {
            Persons persons = personsService.findById(rut);
            return ResponseEntity.ok(persons);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Persons persons) {
        try {
            Persons nuevo = personsService.save(persons);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Persons> actualizar(@PathVariable Integer rut, @RequestBody Persons persons) {
        try {
            Persons per = personsService.findById(rut);
            per.setRut(rut);
            per.setDv(persons.getDv());
            per.setEmail(persons.getEmail());
            per.setPassword(persons.getPassword());
            per.setNames(persons.getNames());
            per.setLast_name(persons.getLast_name());
            per.setBirth_date(persons.getBirth_date());
            per.setRole(persons.getRole());
            per.setPhone(persons.getPhone());
            personsService.save(per);
            return ResponseEntity.ok(persons);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<?> eliminar(@PathVariable Integer rut) {
        try {
            Persons persons = personsService.findById(rut);
            personsService.delete(rut);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró una Persona con ese RUT");
        }
    }

}
