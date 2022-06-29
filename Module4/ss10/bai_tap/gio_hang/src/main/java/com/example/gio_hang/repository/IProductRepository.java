package com.example.gio_hang.repository;

import com.example.gio_hang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {


//    @Query(value = " SELECT * FROM product ", nativeQuery = true)
//    List<Product> selectAllProduct();
//
//    @Query(value = " SELECT * FROM product WHERE id := idSearch ", nativeQuery = true)
//    Product selectProductById(@Param("idSearch") Integer id);

}
