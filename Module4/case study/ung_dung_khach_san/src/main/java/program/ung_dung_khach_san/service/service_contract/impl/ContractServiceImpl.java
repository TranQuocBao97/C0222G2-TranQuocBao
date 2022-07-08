package program.ung_dung_khach_san.service.service_contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.repository.repository_contract.IContractRepository;
import program.ung_dung_khach_san.service.service_contract.IContractService;

import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }



    @Override
    public Page<Contract> findAllByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Contract> findAllByStartDateContaining(String search, Pageable pageable) {
        return iContractRepository.findAllByStartDateContaining(search,pageable);
    }


    @Override
    public Contract save(Contract contract) {
       return iContractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }


}
