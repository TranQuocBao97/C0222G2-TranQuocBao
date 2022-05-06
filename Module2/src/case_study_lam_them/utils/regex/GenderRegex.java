package case_study_lam_them.utils.regex;

public class GenderRegex {
    private static final String REGEX_GENDER_MALE = "^Male$";
    private static final String REGEX_GENDER_FEMALE = "^Female$";
    private static final String REGEX_GENDER_OTHER = "^Other$";

    public static boolean checkGender(String gender){
        if(gender.matches(REGEX_GENDER_MALE)){
            return true;
        }else if(gender.matches(REGEX_GENDER_FEMALE)){
            return true;
        }else {
            return gender.matches(REGEX_GENDER_OTHER);
        }
    }
}
