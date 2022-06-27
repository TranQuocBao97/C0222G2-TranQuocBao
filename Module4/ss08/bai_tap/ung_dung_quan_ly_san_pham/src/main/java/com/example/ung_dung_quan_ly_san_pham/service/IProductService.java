package com.example.ung_dung_quan_ly_san_pham.service;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllProductByNameAndByNameType(String name, String nameType, Pageable pageable);

    void createProduct(Product product);

    void deleteProduct(Integer id);

    Product getProductById(Integer id);
}
