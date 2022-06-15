package validate;

import modal.HocSinh;
import modal.Sach;
import repository.HocSinhRepository;
import repository.SachRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Validate {
    private static final String MA_MUON_SACH = "^MS-[0-9]{4}$";


    public static boolean checkMaMuonSach(String MaMuonSach){
        return MaMuonSach.matches(MA_MUON_SACH);
    }

    public static boolean checkIdSach(String sachId){
        List<Sach> sachList = new SachRepository().getAllSach();
        for(Sach sach : sachList){
            if(sach.getId().equals(sachId)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdHocSinh(String hocsinhId){
        List<HocSinh> hocSinhList = new HocSinhRepository().getListHocSinh();
        for(HocSinh hocSinh : hocSinhList){
            if(hocSinh.getId().equals(hocsinhId)){
                return true;
            }
        }
        return false;
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static boolean checkNgayTraSach(String ngayTraSach){
        Date ngayTraSachTypeDate;
        try {
            ngayTraSachTypeDate = simpleDateFormat.parse(ngayTraSach);
            if(ngayTraSachTypeDate.getTime()>new Date().getTime()){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkOver18 (String birthdayString){
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);
        LocalDate now = LocalDate.now();
        int age = Period.between(birthday, now).getYears();
        if(age>18){
            return true;
        }
        return false;
    }

}
