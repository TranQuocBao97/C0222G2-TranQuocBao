package bai_tap_lam_them_rap_chieu_phim.utils.regex;

import java.util.Scanner;

public class RegexShowtimeCode {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_FILM_SHOWTIME_CODE = "^CI-[0-9]{4}$";

    public static String checkFilmShowtimeCode(String code){
        while (!code.matches(REGEX_FILM_SHOWTIME_CODE)){
            System.out.print("Enter Showtime code again (CI-XXXX): ");
            code = scanner.nextLine();
        }
        return code;
    }
}
