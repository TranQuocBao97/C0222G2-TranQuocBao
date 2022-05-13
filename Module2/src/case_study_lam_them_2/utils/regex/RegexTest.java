package case_study_lam_them_2.utils.regex;

import java.util.Scanner;

public class RegexTest {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_STRING_INPUT  = "^(\\S+)";
    public static String checkStringInput(String stringInput){
        if(!stringInput.matches(REGEX_STRING_INPUT)){
            System.out.print("You cant enter the space type at the head of the line, enter again: ");
            stringInput = scanner.nextLine();
        }
        return stringInput;
    }

}
