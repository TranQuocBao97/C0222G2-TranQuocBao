package com.example.ung_dung_quan_ly_san_pham.dto;

import com.example.ung_dung_quan_ly_san_pham.model.Type;
import com.example.ung_dung_quan_ly_san_pham.repository.ITypeRepository;
import com.example.ung_dung_quan_ly_san_pham.service.ITypeService;
import com.example.ung_dung_quan_ly_san_pham.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class ProductDTO implements Validator {



    private Integer id;

    @NotBlank(message = "không được để trống hay để khoảng trắng dư")
    private String name;

    @Min(value = 500, message = "Sản phẩm có giá 500 đồng trở lên")
    private String price;


    private Type type;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String price, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public ProductDTO(String name, String price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if(productDTO.getName().equals("fuck")){
            errors.rejectValue("name","create.available", "Không được điền từ cấm");
        }
    }


}
