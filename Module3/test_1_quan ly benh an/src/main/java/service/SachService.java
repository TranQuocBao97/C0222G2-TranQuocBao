package service;

import modal.Sach;
import modal.TheMuonSach;
import repository.SachRepository;
import repository.interface_repository.ISachRepository;
import service.interface_Service.ISachService;
import validate.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SachService implements ISachService {
    ISachRepository iSachRepository = new SachRepository();

    @Override
    public List<Sach> getAllSach() {
        return iSachRepository.getAllSach();
    }


}
