package program.app.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.app.model.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);

    Contract findByNameContract(String name);

    Boolean existsByNameContract(String name);
}
