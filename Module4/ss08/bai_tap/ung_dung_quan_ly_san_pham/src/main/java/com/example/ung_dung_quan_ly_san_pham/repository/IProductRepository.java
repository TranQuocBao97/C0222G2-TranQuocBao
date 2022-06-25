package com.example.ung_dung_quan_ly_san_pham.repository;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAllByNameContainingAndTypeNameContaining(String name, String typeName, Pageable pageable);

    Product save(Product product);


    @Modifying
    @Transactional
    void deleteProductById(Integer id);

}
