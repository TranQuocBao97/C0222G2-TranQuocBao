package program.ung_dung_khach_san.service.service_facility.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.ung_dung_khach_san.model.entities_facility.Facility;
import program.ung_dung_khach_san.repository.repository_facility.IFacilityRepository;
import program.ung_dung_khach_san.service.service_facility.IFacilityService;

import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return iFacilityRepository.existsById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return iFacilityRepository.findById(id);
    }
}
