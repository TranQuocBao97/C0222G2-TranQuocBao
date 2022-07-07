package program.ung_dung_khach_san.controller.rest_controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @PutMapping
    public ResponseEntity<Void> editCustomer(@RequestBody Customer customer){
        iCustomerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
