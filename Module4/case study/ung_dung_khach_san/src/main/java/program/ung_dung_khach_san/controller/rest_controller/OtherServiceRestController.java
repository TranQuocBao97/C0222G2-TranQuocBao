package program.ung_dung_khach_san.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.ung_dung_khach_san.model.OtherService;
import program.ung_dung_khach_san.repository.repository_contract.IOtherServiceRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/otherService")
@CrossOrigin
public class OtherServiceRestController {

    @Autowired
    private IOtherServiceRepository iOtherServiceRepository;

    @GetMapping("/{id}")
    public ResponseEntity<OtherService> getOtherService(@PathVariable("id") Integer id){
        Optional<OtherService> otherServiceOptional = iOtherServiceRepository.findById(id);
        if(!otherServiceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(otherServiceOptional.get(),HttpStatus.OK);
    }
}
