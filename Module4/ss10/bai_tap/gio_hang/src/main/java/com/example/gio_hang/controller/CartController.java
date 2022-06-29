package com.example.gio_hang.controller;

import com.example.gio_hang.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {


    @GetMapping("/list")
    public String showCart(@SessionAttribute Cart cartProduct,
                            Model model){
        model.addAttribute("cart",cartProduct);
        return "cart_page";
    }
}
