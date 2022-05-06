package case_study_lam_them.utils.regex;

public class NameRegex {
    private static final String REGEX_ENGLISH_NAME = "^[A-Z][a-zA-Z\\s]+$";
    public static boolean checkName(String name){
        return name.matches(REGEX_ENGLISH_NAME);
    }
}
