package case_study_2.utils.take_data_input_by_condition;

import case_study_2.utils.compareTime.DateString;
import case_study_2.utils.current_time.CurrentTime;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BirthdayOver18Under100Ver2 {
    private static final Scanner scanner = new Scanner(System.in);
    public static String takeBirthdayAvailable(){
        while (true){
            System.out.print("Enter birthday: ");
            String birthdayStr = RegexService.checkDateTimeFormat(scanner.nextLine());
            while (!DateString.checkIsADate(birthdayStr)){
                System.out.print("The date is not exist, enter birthday again: ");
                birthdayStr = RegexService.checkDateTimeFormat(scanner.nextLine());
            }
            String currentDateStr = CurrentTime.getCurrentTime();
            String[] arrayDate = currentDateStr.split("/");
            int currentYear = Integer.parseInt(arrayDate[2]);
            int age18 = currentYear-18;
            int age100 = currentYear-100;
            String dateAge18Str = arrayDate[0]+"/"+arrayDate[1]+"/"+age18;
            String dateAge100Str = arrayDate[0]+"/"+arrayDate[1]+"/"+age100;
            int numberDayForAge18 = DateString.swapToIntegerDay(dateAge18Str);
            int numberDayForAge100 = DateString.swapToIntegerDay(dateAge100Str);
            int numberDayForCurrentTime = DateString.swapToIntegerDay(currentDateStr);
            int numberDayForBirthday = DateString.swapToIntegerDay(birthdayStr);
            int numberDay18AgeToCurrent = numberDayForCurrentTime-numberDayForAge18;
            int numberDay100AgeToCurrent = numberDayForCurrentTime-numberDayForAge100;
            int numberDayBirthdayToCurrent = numberDayForCurrentTime-numberDayForBirthday;
            if(numberDayBirthdayToCurrent>=numberDay18AgeToCurrent && numberDayBirthdayToCurrent<numberDay100AgeToCurrent){
                return  birthdayStr;
            }else {
                System.out.print("Age cant under 18 and more than 100 year old");
            }
        }
    }
}
