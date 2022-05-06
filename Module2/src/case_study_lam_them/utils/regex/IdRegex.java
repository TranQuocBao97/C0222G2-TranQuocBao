package case_study_lam_them.utils.regex;

import java.util.Scanner;

public class IdRegex {
    private static final String REGEX_ID_STUDENT = "^SV-[0-9]{4}$";
    private static final String REGEX_ID_TEACHER = "^GV-[0-9]{4}$";

    public static boolean checkStudentId(String id){
        return id.matches(REGEX_ID_STUDENT);
    }

    public static boolean checkTeacherID(String id){
        return id.matches(REGEX_ID_TEACHER);
    }
}
