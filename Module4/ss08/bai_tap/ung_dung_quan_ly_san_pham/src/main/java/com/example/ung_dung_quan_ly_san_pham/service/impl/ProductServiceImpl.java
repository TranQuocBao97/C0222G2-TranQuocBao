package com.example.ung_dung_quan_ly_san_pham.service.impl;


import com.example.ung_dung_quan_ly_san_pham.model.Product;
import com.example.ung_dung_quan_ly_san_pham.repository.IProductRepository;
import com.example.ung_dung_quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository iProductRepository;


    @Override
    public Page<Product> getAllProductByNameAndByNameType(String name, String nameType, Pageable pageable) {
        return iProductRepository.findAllByNameContainingAndTypeNameContaining(name,nameType,pageable);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        iProductRepository.deleteProductById(id);
    }


}
