package com.backend.Wonderland.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tables") 
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer table_number;

    @Column(nullable = false)
    private String status;

    
}