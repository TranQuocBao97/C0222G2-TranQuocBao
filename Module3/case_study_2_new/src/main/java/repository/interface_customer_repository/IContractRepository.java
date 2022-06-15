package repository.interface_customer_repository;

import modelDTO.ContractDTO;

import java.util.List;

public interface IContractRepository {
    List<ContractDTO> getListContractDTO();
}
