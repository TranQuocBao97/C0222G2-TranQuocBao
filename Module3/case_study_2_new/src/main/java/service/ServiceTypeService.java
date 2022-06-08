package service;

import model.ServiceType;
import repository.ServiceTypeRepository;
import repository.interface_customer_repository.IServiceTypeRepository;
import service.interface_service.IServiceType;

import java.util.List;

public class ServiceTypeService implements IServiceType {
    IServiceTypeRepository iServiceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> getListServiceType() {
        return iServiceTypeRepository.getListServiceType();
    }
}
