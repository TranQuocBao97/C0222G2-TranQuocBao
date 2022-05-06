package case_study_lam_them.utils.regex;

public class BirthdayRegex {
    private static final String
            REGEX_BIRTHDAY = "^((0[1-9])|([12][0-9])|(3[01]))\\/((0[1-9])|(1[12]))\\/([0-9]{4})$";
    public static boolean checkBirthday(String birthday){
        return birthday.matches(REGEX_BIRTHDAY);
    }
}
