package com.backend.Wonderland.Service;

import com.backend.Wonderland.Model.Tables;
import com.backend.Wonderland.Repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TablesService {
    
    @Autowired
    private TablesRepository tablesRepository;
    
    public List<Tables> findAll() {
        return tablesRepository.findAll();
    }

    public Tables findById(Integer id) {
        return tablesRepository.findById(id).get();
    }

    public Tables save(Tables tables) {
        return tablesRepository.save(tables);
    }

    public void delete(Integer id) {
        tablesRepository.deleteById(id);
    }

}
