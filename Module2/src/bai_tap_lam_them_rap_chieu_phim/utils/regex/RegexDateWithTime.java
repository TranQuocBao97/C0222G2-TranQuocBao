package bai_tap_lam_them_rap_chieu_phim.utils.regex;

import java.util.Scanner;

public class RegexDateWithTime {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_DATE_WITH_TIME = "^(([01][0-9])|(2[0-3]))\\:([0-5][0-9])\\s" +
            "((0[1-9])|([12][0-9])|(3[01]))\\/((0[1-9])|(1[0-2]))\\/[0-9]{4}$";

    public static String checkDateStart(String dateTime){
        while (!dateTime.matches(REGEX_DATE_WITH_TIME)){
            System.out.print("Enter date-time again(hh:mm dd/MM/yyyy): ");
            dateTime = scanner.nextLine();
        }
        return dateTime;
    }
}