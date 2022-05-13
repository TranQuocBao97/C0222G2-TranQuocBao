package bai_thi.services.class_implement;

import bai_thi.models.sub_phone.RealPhone;
import bai_thi.services.IRealPhone;
import bai_thi.utils.get_input_number.IntegerInput;
import bai_thi.utils.read_and_write.ReadFile;
import bai_thi.utils.read_and_write.WriteFile;
import bai_thi.utils.regex.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealPhoneService implements IRealPhone {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_REAL_PHONE = "src/bai_thi/data/file_data_real_phone.csv";
    private static List<RealPhone> realPhoneList = new ArrayList<>();
    static {
        realPhoneList = ReadFile.readFileDataToRealPhoneList(FILE_DATA_REAL_PHONE);
    }

    @Override
    public void add() {
        Integer id = PhoneService.addId();
        System.out.print("Add phone name: ");
        String name = Regex.checkStringInput(scanner.nextLine());
        System.out.print("Add price: ");
        Integer price = IntegerInput.checkIntegerInputOverZero();
        System.out.print("Add have number of phone: ");
        Integer numberPhoneHave = IntegerInput.checkIntegerInputOverZero();
        System.out.print("Add factory company was made the phone: ");
        String factory = Regex.checkStringInput(scanner.nextLine());
        System.out.print("Add Time Support: ");
        Integer timeSupport = IntegerInput.checkIntegerInputOverZero();
        while (timeSupport>730){
            System.out.print("Time support cant over 730 days, enter again: ");
            timeSupport = IntegerInput.checkIntegerInputOverZero();
        }
        System.out.print("Add area support (Area support have to 'Toan Quoc' or 'Quoc Te):");
        String areaSupport = Regex.checkAreaSupport();

        realPhoneList.add(new RealPhone(id, name, price,numberPhoneHave,factory,timeSupport,areaSupport));
        System.out.println("Success to add real phone");
        WriteFile.writeListRealPhoneToCsv(FILE_DATA_REAL_PHONE,realPhoneList,false);
    }

    @Override
    public void delete() {

    }

    @Override
    public void display() {
        System.out.println("Display List real phone: ");
        for(RealPhone realPhone : realPhoneList){
            System.out.println(realPhone);
        }
    }

    @Override
    public void search() {

    }
}
