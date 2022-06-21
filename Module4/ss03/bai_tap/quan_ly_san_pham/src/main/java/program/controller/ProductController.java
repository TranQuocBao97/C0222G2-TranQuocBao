package program.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import program.model.Product;
import program.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String indexTest() {
        return "/index";
    }

    @GetMapping("/list")
    public String displayList(Model model) {
        List<Product> productList = iProductService.getAll();
        model.addAttribute("productList", productList);
        model.addAttribute("product",new Product());
        return "/list-product";
    }

    @GetMapping("/add-page")
    public String displayAddPage(Model model) {
        model.addAttribute("product", new Product());
        return "/add-product";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        product.setId((int) (Math.random() * 1000));
        iProductService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit-page/{id}")
    public String editPage(@PathVariable int id,
                           Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete-page")
    public String deletePage(@RequestParam Integer id,
                             Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete-product";
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product) {
        iProductService.delete(product.getId());
        return "redirect:/product/list";
    }

    @GetMapping("/search-by-name")
    public String searchProduct(@RequestParam String name,
                                Model model) {
        List<Product> productList = iProductService.findByName(name);
        model.addAttribute("nameSearch",name);
        model.addAttribute("productList", productList);
        return "/list-product";
    }

    @GetMapping("/detail-page/{id}")
    public String detailProduct(@PathVariable int id,
                                Model model){
        model.addAttribute("product",iProductService.findById(id));

        return "/detail-product";
    }

}
