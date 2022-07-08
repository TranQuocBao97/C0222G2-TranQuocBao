package program.ung_dung_khach_san.repository.repository_contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import program.ung_dung_khach_san.model.Contract;

import java.util.Optional;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findAllByStartDateContaining (String searchWord,Pageable pageable);

    @Modifying
    void deleteById(Integer id);

    boolean existsById(Integer id);

    Contract save(Contract contract);

    Optional<Contract> findById(Integer id);

}
