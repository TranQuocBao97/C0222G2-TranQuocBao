package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Validate {
    private static final String NAME = "^((?![0-9\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\=\\-\\[\\]\\{\\}\\;\\:\\\"\\\\\\/\\<\\>\\?\\.]).)+$";
    private static final String EMAIL = "^\\w+@\\w+\\.\\w+$";



    public static boolean checkName(String name){
        return name.matches(NAME);
    }
    public static boolean checkEmail(String email){
        return email.matches(EMAIL);
    }
    public static boolean checkPositiveNumber(String numberString){
        return Integer.parseInt(numberString) > 0;
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static boolean checkDateType(String date){
        Date dateParse;
        try {
            dateParse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean checkBirthdayTime(String date){
        Date dateParse;
        try {
            dateParse = simpleDateFormat.parse(date);
            if(dateParse.getTime()>new Date().getTime()){
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean checkOver18 (String birthdayString){
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);
        LocalDate now = LocalDate.now();
        int age = Period.between(birthday, now).getYears();
        if(age>18){
            return true;
        }
        return false;
    }


}
