package com.backend.Wonderland.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "orderitems") 
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class OrderItems {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_order") // El nombre de la columna FK en la tabla de la BD
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "id_product") // El nombre de la columna FK en la tabla de la BD
    private Products products;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

}
