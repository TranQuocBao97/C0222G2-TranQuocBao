package ss19_string_adn_regex.bai_tap.validate_ten_lop_hoc;


import java.util.Scanner;

public class ValidateTenLopHoc {
    private static final String NAME_CLASS_REGEX = "^[C,A,P][0-9]{4}[G,H,I,K,L,M]$";
    private static final String NAME_CLASS_REGEX_2 = "^[C,A,P]\\d{4}[G,H,I,K,L,M]$";
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Nhập tên lớp học: ");
        String className = scanner.nextLine();
        while (!(className.matches(NAME_CLASS_REGEX))){
            System.out.print("Tên Lớp học ko hợp lệ, xin nhập lại: ");
            className = scanner.nextLine();
        }
        while (!(className.matches(NAME_CLASS_REGEX_2))){
            System.out.print("Tên Lớp học ko hợp lệ, xin nhập lại: ");
            className = scanner.nextLine();
        }
        System.out.println("Tên class hợp lệ: "+className);

    }
}
