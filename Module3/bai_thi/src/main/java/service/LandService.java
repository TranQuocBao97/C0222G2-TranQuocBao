package service;

import model.Land;
import repository.LandRepository;
import repository.interface_repository.ILandRepository;
import service.interface_service.ILandService;

import java.util.HashMap;
import java.util.Map;

public class LandService implements ILandService {
    ILandRepository iLandRepository = new LandRepository();

    @Override
    public Map<String, String> insertLand(Land land) {
        Map<String,String> messMap = new HashMap<>();
        boolean checkAdd = iLandRepository.insertLand(land);
        return messMap;
    }
}
