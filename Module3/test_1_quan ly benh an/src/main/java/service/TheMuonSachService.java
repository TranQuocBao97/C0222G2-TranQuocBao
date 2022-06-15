package service;

import modal.TheMuonSach;
import repository.SachRepository;
import repository.TheMuonSachRepository;
import repository.interface_repository.ISachRepository;
import repository.interface_repository.ITheMuonSachRepository;
import service.interface_Service.ITheMuonSachService;
import validate.Validate;

import java.util.HashMap;
import java.util.Map;

public class TheMuonSachService implements ITheMuonSachService {
    ITheMuonSachRepository iTheMuonSachRepository = new TheMuonSachRepository();
    ISachRepository iSachRepository = new SachRepository();
    @Override
    public Map<String, String> insertTheMuonSach(TheMuonSach theMuonSach) {
        Map<String,String> errorMap = new HashMap<>();
        if(!Validate.checkMaMuonSach(theMuonSach.getId())){
            errorMap.put("idTheMuonSach","Tên thẻ mượn Sách không hợp lệ");
        }
        if(!Validate.checkIdSach(theMuonSach.getSachId())){
            errorMap.put("idSach","Sách không hợp lệ");
        }
        if(!Validate.checkIdHocSinh(theMuonSach.getHocSinhId())){
            errorMap.put("idHocSinh","Học sinh không hợp lệ");
        }
        if(!Validate.checkNgayTraSach(theMuonSach.getDateEnd())){
            errorMap.put("ngayTraSach","Ngày trả sách không hợp lệ");
        }
        if(errorMap.isEmpty()){
            Map<String,String> messMap = new HashMap<>();
            boolean checkAddTheMuonSach = iTheMuonSachRepository.addTheMuonSach(theMuonSach);
            if(checkAddTheMuonSach){
                messMap.put("mess","true");
                iSachRepository.updateTruSoLuongSach(theMuonSach.getSachId());
            }else {
                messMap.put("mess","false");
            }
            return messMap;
        }

        return errorMap;
    }
}
