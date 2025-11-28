package com.backend.Wonderland.Repository;

import com.backend.Wonderland.Model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends JpaRepository <Persons, Integer> {

}
