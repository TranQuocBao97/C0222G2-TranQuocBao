package program.app.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.app.model.Contract;
import program.app.repository.IContractRepository;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/contract")
public class MainModelRestController {

    @Autowired
    private IContractRepository iContractRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainModel(@PathVariable Integer id) {
        Optional<Contract> contractOptional = iContractRepository.findById(id);
        if (!contractOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iContractRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
