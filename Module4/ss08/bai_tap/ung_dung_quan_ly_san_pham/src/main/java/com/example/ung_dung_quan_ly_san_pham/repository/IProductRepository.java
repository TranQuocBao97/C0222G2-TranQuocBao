package com.example.ung_dung_quan_ly_san_pham.repository;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAllByNameContainingAndTypeNameContaining(String name, String typeName, Pageable pageable);

    List<Product> findAll();

    Product save(Product product);


    @Modifying
    @Transactional
    void deleteProductById(Integer id);

    Product findProductById(Integer id);

}
