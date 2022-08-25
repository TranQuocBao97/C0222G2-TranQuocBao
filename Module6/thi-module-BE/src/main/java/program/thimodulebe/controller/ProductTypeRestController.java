package program.thimodulebe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.thimodulebe.model.ProductType;
import program.thimodulebe.repository.IProductTypeRepository;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/product-type")
public class ProductTypeRestController {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @GetMapping
    public ResponseEntity<List<ProductType>> getAllProduct() {
        List<ProductType> productTypes = iProductTypeRepository.getAllTypeProduct();
        if (productTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productTypes, HttpStatus.OK);
    }


}
