package com.backend.Wonderland.Service;

import com.backend.Wonderland.Model.Products;
import com.backend.Wonderland.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;
    
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Products findById(Integer id) {
        return productsRepository.findById(id).get();
    }

    public Products save(Products products) {
        return productsRepository.save(products);
    }

    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }

}
