package com.example.gio_hang.controller;

import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes("listProductCart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("listProductCart")
    public List<Product> listProductCart(){
        return new ArrayList<>();
    }


    @GetMapping("/product-list")
    public String displayProduct(Model model){
        List<Product> productList = iProductService.getAllProduct();
        model.addAttribute("productList",productList);
        return "display_product";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id,
                            @SessionAttribute("listProductCart") List<Product> listProductCart){
        Product product = iProductService.getProductById(id);
        System.out.print(product.getName());
        listProductCart.add(product);
        return "redirect:/product/product-list";
    }

    @GetMapping("/cart")
    public String showCart(@SessionAttribute("listProductCart") List<Product> listProductCart,
                           Model model){
        model.addAttribute("listProductCart",listProductCart);
        return "cart_page";
    }

}
