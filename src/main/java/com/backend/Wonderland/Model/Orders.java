package com.backend.Wonderland.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Table(name= "orders") 
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_table") // El nombre de la columna FK en la tabla de la BD
    private Tables tables;

    @ManyToOne
    @JoinColumn(name = "id_person") // El nombre de la columna FK en la tabla de la BD
    private Persons persons;

    @Column(nullable = false)
    private Integer total;

    @Column(nullable = false)
    private LocalDate date;

}