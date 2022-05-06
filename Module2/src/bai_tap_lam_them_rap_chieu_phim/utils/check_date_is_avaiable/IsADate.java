package bai_tap_lam_them_rap_chieu_phim.utils.check_date_is_avaiable;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class IsADate {
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("kk:mm dd/MM/yyyy");

    public static boolean checkIsADate(String dateTimeString){
        LocalDate localDate = LocalDate.parse(dateTimeString, format);
        String localDateString = String.valueOf(localDate);
        String[] arrayLocalDateString = localDateString.split("-");
        String newLocalDateString = arrayLocalDateString[2]+"/"+arrayLocalDateString[1]+"/"+arrayLocalDateString[0];
        String[] arrayDateTimeString = dateTimeString.split(" ");
        String dateString = arrayDateTimeString[1];
        return dateString.equals(newLocalDateString);
    }
}
