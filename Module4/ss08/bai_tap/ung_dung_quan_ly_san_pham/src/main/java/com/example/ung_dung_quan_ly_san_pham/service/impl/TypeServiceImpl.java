package com.example.ung_dung_quan_ly_san_pham.service.impl;

import com.example.ung_dung_quan_ly_san_pham.model.Type;
import com.example.ung_dung_quan_ly_san_pham.repository.ITypeRepository;
import com.example.ung_dung_quan_ly_san_pham.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;


    @Override
    public Page<Type> getAllTypeByName(String name, Pageable pageable) {
        return iTypeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Type> getAllType() {
        return iTypeRepository.selectAllType();
    }

    @Override
    public boolean checkIdAvailable(Integer id) {
        return iTypeRepository.existsById(id);
    }
}
