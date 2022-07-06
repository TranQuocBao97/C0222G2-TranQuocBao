package program.ung_dung_khach_san.repository.repository_facility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_facility.RentType;

import java.util.List;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
    List<RentType> findAll();
}
