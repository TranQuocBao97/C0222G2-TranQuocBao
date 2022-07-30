package program.ung_dung_khach_san.repository.repository_contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import program.ung_dung_khach_san.model.ContractOtherService;

import java.util.List;

@Repository
public interface IContractOtherServiceRepository extends JpaRepository<ContractOtherService,Integer> {

    List<ContractOtherService> findAll();

    @Transactional
    @Modifying
    @Query(value = " DELETE FROM contract_other_service WHERE contract_id = :contractId ",nativeQuery = true)
    void deleteContractOtherServicesByContractId(@Param("contractId") Integer id);

}
