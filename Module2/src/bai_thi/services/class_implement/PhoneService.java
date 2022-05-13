package bai_thi.services.class_implement;

import bai_thi.models.Phone;
import bai_thi.models.sub_phone.HandPhone;
import bai_thi.models.sub_phone.RealPhone;
import bai_thi.services.IService;
import bai_thi.utils.read_and_write.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneService {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_HAND_PHONE = "src/bai_thi/data/file_data_hand_phone.csv";
    private static final String FILE_DATA_REAL_PHONE = "src/bai_thi/data/file_data_real_phone.csv";
    private static  List<HandPhone> handPhoneList = new ArrayList<>();
    private static  List<RealPhone> realPhoneList = new ArrayList<>();



    public static Integer addId() {
        return checkId();
    }

    public static Integer checkId() {
        handPhoneList = ReadFile.readFileDataToHandPhoneList(FILE_DATA_HAND_PHONE);
        realPhoneList = ReadFile.readFileDataToRealPhoneList(FILE_DATA_REAL_PHONE);
        Integer id = 0;
        try{
            for (RealPhone realPhone : realPhoneList){
                if (realPhone.getId()>id){
                    id=realPhone.getId();
                }
            }
            for(HandPhone handPhone : handPhoneList){
                if(handPhone.getId()>id){
                    id = handPhone.getId();
                }
            }
        }catch (Exception e){
            System.out.println("File have nothing");
        }
        return ++id;
    }
}
