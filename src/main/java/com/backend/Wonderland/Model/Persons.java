package com.backend.Wonderland.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name= "persons") 
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Persons {

    @Id
    private Integer rut;

    @Column(nullable = true)
    private Integer dv;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String names;

    @Column(nullable = true)
    private String last_name;

    @Column(nullable = true)
    private LocalDate birth_date;

    @Column(nullable = true)
    private String role;

    @Column(nullable = true)
    private Integer phone;

    @OneToMany(mappedBy = "persons")
    @JsonIgnoreProperties("persons")
    private List<Orders> ordersList;
    
}
