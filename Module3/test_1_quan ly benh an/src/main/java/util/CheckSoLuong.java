package util;

import modal.Sach;
import repository.SachRepository;

import java.util.List;

public class CheckSoLuong {
    public static boolean checkSoLuong(String id){
        List<Sach> sachList = new SachRepository().getAllSach();
        for (Sach sach : sachList){
            if(sach.getId().equals(id)){
                if(Integer.parseInt(sach.getNumber())<1){
                    return false;
                }
            }
        }
        return true;
    }
}
