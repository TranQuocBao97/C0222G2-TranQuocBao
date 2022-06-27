package com.example.ung_dung_quan_ly_san_pham.service;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import com.example.ung_dung_quan_ly_san_pham.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeService {
    Page<Type> getAllTypeByName(String name, Pageable pageable);
    List<Type> getAllType();

    boolean checkIdAvailable(Integer id);
}
