package program.ung_dung_khach_san.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import program.ung_dung_khach_san.dto.TotalCostDTO;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.repository.repository_contract.ITotalCostDtoRepository;
import program.ung_dung_khach_san.repository.repository_contract.IContractRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/contract")
public class ContractRestController {

    @Autowired
    private IContractRepository iContractRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Contract>> getContractPage(){
        List<Contract> totalCostDTOList = iContractRepository.findAll();
        return new ResponseEntity<>(totalCostDTOList, HttpStatus.OK);
    }

    @Autowired
    private ITotalCostDtoRepository iTotalCostDtoRepository;

    @GetMapping("/totalCost")
    public ResponseEntity<List<TotalCostDTO>> getTotalCost(){
        List<TotalCostDTO> totalCostDTOS = iTotalCostDtoRepository.selectTotalCost();
        return new ResponseEntity<>(totalCostDTOS, HttpStatus.OK);
    }

}
