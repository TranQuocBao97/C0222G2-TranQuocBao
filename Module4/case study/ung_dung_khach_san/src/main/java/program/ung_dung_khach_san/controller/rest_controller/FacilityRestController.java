package program.ung_dung_khach_san.controller.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.ung_dung_khach_san.dto.FacilityDTO;
import program.ung_dung_khach_san.model.entities_facility.Facility;
import program.ung_dung_khach_san.model.entities_facility.RentType;
import program.ung_dung_khach_san.repository.repository_facility.IRentTypeRepository;
import program.ung_dung_khach_san.service.service_facility.IFacilityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facility")
@CrossOrigin
public class FacilityRestController {

    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<FacilityDTO> getFacilityById(@PathVariable("id") Integer id) {
        Optional<Facility> facilityOptional = iFacilityService.findById(id);
        List<RentType> rentTypeList = iRentTypeRepository.findAll();
        if (!facilityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FacilityDTO facilityDTO = new FacilityDTO();
        facilityDTO.setFacility(facilityOptional.get());
        facilityDTO.setRentTypeList(rentTypeList);
//        return new ResponseEntity<>(facilityOptional.get(), HttpStatus.OK);
        return new ResponseEntity<>(facilityDTO, HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Facility> getOneFacilityById(@PathVariable("id") Integer id){
        Optional<Facility> facilityOptional = iFacilityService.findById(id);
        if (!facilityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityOptional.get(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> editFacility(@RequestBody Facility facility){
        iFacilityService.save(facility);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Facility>> getPageFacility(@PageableDefault(value = 6) Pageable pageable) {
        Page<Facility> facilityPage = iFacilityService.findAll(pageable);
        return new ResponseEntity<>(facilityPage, HttpStatus.OK);
    }
}
