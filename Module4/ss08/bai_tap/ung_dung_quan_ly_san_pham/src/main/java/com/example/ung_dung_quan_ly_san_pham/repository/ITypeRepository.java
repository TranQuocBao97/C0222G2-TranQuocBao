package com.example.ung_dung_quan_ly_san_pham.repository;


import com.example.ung_dung_quan_ly_san_pham.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeRepository extends JpaRepository<Type,Integer> {

    Page<Type> findAllByNameContaining(String name, Pageable pageable);


    @Query(value = " SELECT * FROM type",nativeQuery = true)
    List<Type> selectAllType();

    boolean existsById(Integer id);

}
