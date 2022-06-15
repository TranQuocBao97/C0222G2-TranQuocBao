package service;

import repository.ServiceRepository;
import repository.interface_customer_repository.IServiceRepository;
import service.interface_service.IService;

import java.util.List;

public class Service implements IService {
    IServiceRepository iServiceRepository = new ServiceRepository();


    @Override
    public boolean addNewService(model.Service service) {
        return iServiceRepository.addNewService(service);
    }

    @Override
    public List<model.Service> getAllService() {
        return iServiceRepository.getAllService();
    }
}