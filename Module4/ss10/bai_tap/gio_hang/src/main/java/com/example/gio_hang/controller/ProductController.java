package com.example.gio_hang.controller;

import com.example.gio_hang.model.Cart;
import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = {"cartProduct"})
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cartProduct")
    public Cart setupCart() {
        return new Cart();
    }


    @GetMapping("/product-list")
    public String displayProduct(Model model) {
        List<Product> productList = iProductService.getAllProduct();
        model.addAttribute("productList", productList);
        return "display_product";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @RequestParam("action") String action,
                            @SessionAttribute Cart cartProduct,
                            RedirectAttributes redirectAttributes) {
        Product product = iProductService.getProductById(id);
        if(action.equals("add")){
            cartProduct.addProduct(product);
            return "redirect:/cart/list";
        }
        if(action.equals("minus")){
            cartProduct.minusProduct(product);
            return "redirect:/cart/list";
        }

        cartProduct.addProduct(product);
        redirectAttributes.addFlashAttribute("mess","Đã thêm mới thành công");
        return "redirect:/product/product-list";
    }

}
