package program.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.store.model.Product;
import program.store.repository.repository_pack.IProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductRestController {
    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> productList = iProductRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }



}
