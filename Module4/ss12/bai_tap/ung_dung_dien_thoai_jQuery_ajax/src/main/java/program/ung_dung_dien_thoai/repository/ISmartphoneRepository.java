package program.ung_dung_dien_thoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_dien_thoai.model.Smartphone;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}