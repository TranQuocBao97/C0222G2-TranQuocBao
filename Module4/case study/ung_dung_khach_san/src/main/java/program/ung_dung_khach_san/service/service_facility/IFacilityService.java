package program.ung_dung_khach_san.service.service_facility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.entities_facility.Facility;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);
    void deleteById(Integer id);
    boolean existsById(Integer id);

    void save(Facility facility);
    Optional<Facility> findById(Integer id);
}
