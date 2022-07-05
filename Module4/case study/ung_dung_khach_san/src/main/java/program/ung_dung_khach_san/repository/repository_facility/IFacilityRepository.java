package program.ung_dung_khach_san.repository.repository_facility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_facility.Facility;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    Page<Facility> findAll(Pageable pageable);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
