package program.ung_dung_khach_san.service.service_contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.entities_customer.Customer;

import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findAllByName(String name,Pageable pageable);
    Page<Contract> findAllByStartDateContaining(String search, Pageable pageable);
    Contract save(Contract contract);

    Optional<Contract> findById(Integer id);

    void deleteById(Integer id);

    boolean existsById(Integer id);


}
