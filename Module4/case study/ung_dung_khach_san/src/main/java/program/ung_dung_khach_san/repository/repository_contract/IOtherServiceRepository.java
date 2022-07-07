package program.ung_dung_khach_san.repository.repository_contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.OtherService;

import java.util.List;

@Repository
public interface IOtherServiceRepository extends JpaRepository<OtherService,Integer> {
    List<OtherService> findAll();
}
