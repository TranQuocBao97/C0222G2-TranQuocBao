package service.interface_service;

import model.Land;
import repository.LandRepository;
import repository.interface_repository.ILandRepository;

import java.util.Map;

public interface ILandService {
    ILandRepository iLandRepository = new LandRepository();

    Map<String, String> insertLand(Land land);
}
