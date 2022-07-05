package program.ung_dung_khach_san.repository.repository_facility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_facility.FacilityType;

import java.util.List;

@Repository
public interface IFacilityTypeRepository  extends JpaRepository<FacilityType,Integer> {
    List<FacilityType> findAll();
}
