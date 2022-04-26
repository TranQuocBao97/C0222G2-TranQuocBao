package ss19_string_adn_regex.bai_tap.validate_so_dien_thoai;

import java.util.Scanner;

public class ValidateSoDienThoai {
    private static final String PHONE_NUMBER_REGEX = "^\\([0-9]{2}\\)\\-\\(0[0-9]{9}\\)$";
    private static final String PHONE_NUMBER_REGEX_2 = "^\\(\\d{2}\\)\\-\\(0\\d{9}\\)$";
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        while (!(phoneNumber.matches(PHONE_NUMBER_REGEX))){
            System.out.print("Số điện thoại ko hợp lệ, nhập lại: ");
            phoneNumber = scanner.nextLine();
        }
        while (!(phoneNumber.matches(PHONE_NUMBER_REGEX_2))){
            System.out.print("Số điện thoại ko hợp lệ, nhập lại: ");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("sđt: "+phoneNumber);
    }
}
