package ss01_introduction_to_Java.thuc_hanh;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("witch month that yout want to count days? ");
        int month = scanner.nextInt();
        String daysInMonth;
            switch (month) {
                case 2:
                    daysInMonth = "28 or 29";
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysInMonth = "31";
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    daysInMonth = "30";
                    break;
                default:
                    daysInMonth = "";
            }
        if (!daysInMonth.equals("")) System.out.printf("the month '%d' has %s days!", month, daysInMonth);
        else System.out.println("Invalid input!");
    }
}
