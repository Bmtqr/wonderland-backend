package com.backend.Wonderland.Repository;

import com.backend.Wonderland.Model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablesRepository extends JpaRepository <Tables, Integer> {
    
}
