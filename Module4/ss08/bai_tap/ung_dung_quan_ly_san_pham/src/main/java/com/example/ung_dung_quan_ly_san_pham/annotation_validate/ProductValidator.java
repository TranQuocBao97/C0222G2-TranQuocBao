package com.example.ung_dung_quan_ly_san_pham.annotation_validate;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import com.example.ung_dung_quan_ly_san_pham.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ProductValidator implements ConstraintValidator<ValidateProduct,String> {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public boolean isValid(String nameProduct, ConstraintValidatorContext context) {
        List<Product> productList = iProductRepository.findAll();
        for(Product product : productList){
            if(product.getName().equals(nameProduct)){
                return false;
            }
        }
        return true;
    }
}
