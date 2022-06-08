package service.interface_service;

import model.Service;

import java.util.List;

public interface IService {
    boolean addNewService(Service service);

    List<Service> getAllService();
}
