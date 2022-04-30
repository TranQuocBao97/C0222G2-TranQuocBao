package case_study_2.utils.compareTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateString {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Integer swapToIntegerDay(String dateString) {
        Date date = null;
        Integer numberOfDay = null;
        try {
            date = simpleDateFormat.parse(dateString);
            numberOfDay = Math.toIntExact(date.getTime() / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numberOfDay;
    }

    public static boolean checkIsADate(String dateString) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate local = LocalDate.parse(dateString, format);
            String date = String.valueOf(local);
            String[] dateArray = date.split("-");
            String dateStrForCheck = dateArray[2] + "/" + dateArray[1] + "/" + dateArray[0];
            if(dateString.equals(dateStrForCheck)){
                return true;
            }else {
                System.out.println(dateString+" <- This date is not exist");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println(dateString+" <- This date is not exist");
            return false;
        }
    }
}
