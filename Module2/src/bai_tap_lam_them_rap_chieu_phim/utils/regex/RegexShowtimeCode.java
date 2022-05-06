package bai_tap_lam_them_rap_chieu_phim.utils.regex;

public class RegexShowtimeCode {
    private static final String REGEX_FILM_SHOWTIME_CODE = "^CI-[0-9]{4}$";

    public static boolean checkFilmShowtimeCode(String code){
        return code.matches(REGEX_FILM_SHOWTIME_CODE);
    }
}
