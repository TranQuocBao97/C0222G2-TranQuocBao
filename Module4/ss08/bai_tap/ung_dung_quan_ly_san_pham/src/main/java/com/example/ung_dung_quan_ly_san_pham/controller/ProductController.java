package com.example.ung_dung_quan_ly_san_pham.controller;

import com.example.ung_dung_quan_ly_san_pham.dto.FirstGroup;
import com.example.ung_dung_quan_ly_san_pham.dto.ProductDTO;
import com.example.ung_dung_quan_ly_san_pham.model.Product;
import com.example.ung_dung_quan_ly_san_pham.repository.IProductRepository;
import com.example.ung_dung_quan_ly_san_pham.service.IProductService;
import com.example.ung_dung_quan_ly_san_pham.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @Autowired
    ITypeService iTypeService;

    @GetMapping("/list-product")
    public String displayListProduct(@PageableDefault(value = 5) Pageable pageable,
                                     @RequestParam("nameSearch") Optional<String> nameSearch,
                                     @RequestParam("nameTypeSearch") Optional<String> nameTypeSearch,
                                     Model model) {
        String nameSearchValue = nameSearch.orElse("");
        String nameTypeSearchValue = nameTypeSearch.orElse("");
        Page<Product> productList = iProductService.getAllProductByNameAndByNameType(nameSearchValue, nameTypeSearchValue, pageable);
        model.addAttribute("productList", productList);
        model.addAttribute("nameSearchValue", nameSearchValue);
        model.addAttribute("nameTypeSearchValue", nameTypeSearchValue);
        return "product-list";
    }

    @GetMapping("/add-product")
    public String displayAddForm(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("typeList",iTypeService.getAllType());
        return "product-add";
    }

    @PostMapping("/creat-product")
    public String createProduct(@ModelAttribute("productDTO") @Validated() ProductDTO productDTO,
                                BindingResult bindingResult,
                                Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("typeList",iTypeService.getAllType());
            return "product-add";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.createProduct(product);
        return "redirect:/product/list-product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        iProductService.deleteProduct(id);
        return "redirect:/product/list-product";
    }


    @GetMapping("/edit-product/{id}")
    public String displayEdit(@PathVariable Integer id,
                              Model model){
        Product product = iProductService.getProductById(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        model.addAttribute("productDTO",productDTO);
        model.addAttribute("typeList",iTypeService.getAllType());
        return "product-edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("productDTO") @Valid ProductDTO productDTO,
                                BindingResult bindingResult,
                                Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("typeList",iTypeService.getAllType());
            return "product-edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.createProduct(product);
        return "redirect:/product/list-product";
    }


    @Autowired
    IProductRepository iProductRepository;

    @GetMapping("/test")
    public String test(@RequestParam Optional<Integer> page,
                       @RequestParam Optional<String> sortBy,
                       Model model){
        Page<Product> productPage = iProductRepository.findAll(PageRequest.of(page.orElse(0),2,
                Sort.Direction.ASC,sortBy.orElse("id")));
        model.addAttribute("productPage",productPage);
        return "test-table";
    }

}
