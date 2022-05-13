package bai_thi.services.class_implement;

import bai_thi.models.sub_phone.HandPhone;
import bai_thi.services.IHandPhone;
import bai_thi.utils.get_input_number.IntegerInput;
import bai_thi.utils.read_and_write.ReadFile;
import bai_thi.utils.read_and_write.WriteFile;
import bai_thi.utils.regex.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandPhoneService implements IHandPhone {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_HAND_PHONE = "src/bai_thi/data/file_data_hand_phone.csv";
    private static List<HandPhone> handPhoneList = new ArrayList<>();

    static {
        handPhoneList = ReadFile.readFileDataToHandPhoneList(FILE_DATA_HAND_PHONE);
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
        System.out.print("Add country was made the phone: ");
        String country = Regex.checkStringInput(scanner.nextLine());
        System.out.print("Add fix type: ");
        String fixType = Regex.checkFixType();

        handPhoneList.add(new HandPhone(id, name, price, numberPhoneHave, factory, country, fixType));
        System.out.println("Success to add hand phone");
        WriteFile.writeListHandPhoneToCsv(FILE_DATA_HAND_PHONE, handPhoneList, false);

    }


    @Override
    public void delete() {

    }

    @Override
    public void display() {
        System.out.println("List Hand phone: ");
        for (HandPhone handPhone : handPhoneList) {
            System.out.println(handPhone);
        }
    }

    @Override
    public void search() {

    }
}
