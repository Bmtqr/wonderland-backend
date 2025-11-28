package com.backend.Wonderland.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "products") 
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false) // El precio del producto
    private Integer price;    

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer sales;

    @Column(nullable = false)
    private String image_url;
    
}
