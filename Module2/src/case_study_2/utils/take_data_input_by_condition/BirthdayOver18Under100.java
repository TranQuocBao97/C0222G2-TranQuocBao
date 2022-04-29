package case_study_2.utils.take_data_input_by_condition;

import case_study_2.utils.current_time.CurrentTime;
import case_study_2.utils.take_data_input_by_regex.RegexService;
import case_study_2.utils.user_exception.ExceptionAgeOver100Under18;

import java.util.Scanner;

public class BirthdayOver18Under100 {
    private static Scanner scanner = new Scanner(System.in);
    public static String takeBirthDay(){
        while (true){
            try{
                System.out.print("birth: ");
                String birthTime = RegexService.checkDateTimeFormat(scanner.nextLine());
                String currentTime = CurrentTime.getCurrentTime();
                String[] birth = birthTime.split("/");
                Integer birthDate = Integer.parseInt(birth[0]);
                Integer birthMonth = Integer.parseInt(birth[1]);
                Integer birthYear = Integer.parseInt(birth[2]);
                String[] current = currentTime.split("/");
                Integer currentDate = Integer.parseInt(current[0]);
                Integer currentMonth = Integer.parseInt(current[1]);
                Integer currentYear = Integer.parseInt(current[2]);
                if (currentYear - birthYear > 100 || currentYear-birthYear <18) {
                    throw new ExceptionAgeOver100Under18();
                }
                if (currentYear - birthYear > 18 && currentYear - birthYear < 100) {
                    return birthTime;
                }
                if (currentYear - birthYear == 100)
                    if(currentMonth > birthMonth) {
                        throw new ExceptionAgeOver100Under18();
                    } else if(currentMonth < birthMonth){
                        return birthTime;
                    } else {
                        if(currentDate<=birthDate){
                            return birthTime;
                        }else {
                            throw new ExceptionAgeOver100Under18();
                        }
                    }

                if (currentMonth > birthMonth) {
                    return birthTime;
                } else if (currentMonth < birthMonth) {
                    throw new ExceptionAgeOver100Under18();
                } else {
                    if(currentDate>birthDate){
                        return birthTime;
                    }else {
                        throw new ExceptionAgeOver100Under18();
                    }
                }
            }catch (ExceptionAgeOver100Under18 e){
                System.out.println("The ege is not define");
            }

        }

    }
}
