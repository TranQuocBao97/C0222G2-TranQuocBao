package program.thimodulebe.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import program.thimodulebe.dto.ProductDTO;
import program.thimodulebe.model.Product;
import program.thimodulebe.repository.IProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    IProductRepository iProductRepository;

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(5) Pageable pageable,
                                                       Optional<String> searchType) {
        String searchTypeProduct = searchType.orElse("");
        Page<Product> products = iProductRepository.findAll(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = iProductRepository.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        Optional<Product> product = iProductRepository.findById(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iProductRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDTO productAdd, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productAdd, product);

        iProductRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
