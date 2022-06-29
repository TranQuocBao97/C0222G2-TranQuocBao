package com.example.gio_hang.service.impl;

import com.example.gio_hang.model.Product;
import com.example.gio_hang.repository.IProductRepository;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return iProductRepository.getById(id);
    }

}
