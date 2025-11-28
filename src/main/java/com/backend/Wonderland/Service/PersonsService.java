package com.backend.Wonderland.Service;

import com.backend.Wonderland.Model.Persons;
import com.backend.Wonderland.Repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;
    
    public List<Persons> findAll() {
        return personsRepository.findAll();
    }

    public Persons findById(Integer rut) {
        return personsRepository.findById(rut).get();
    }

    public Persons save(Persons persons) {
        return personsRepository.save(persons);
    }

    public void delete(Integer rut) {
        personsRepository.deleteById(rut);
    }

}
