package bai_thi.utils.regex;

import java.util.Scanner;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_STRING_INPUT  = "^(\\S+)";
    private static final String REGEX_TOAN_QUOC = "^Toan Quoc$";
    private static final String REGEX_QUOC_TE  = "^Quoc Te$";
    private static final String REGEX_DA_SUA_CHUA = "^Da sua chua$";
    private static final String REGEX_CHUA_SUA_CHUA = "^Chua sua chua$";

    public static String checkStringInput(String stringInput){
        if(!stringInput.matches(REGEX_STRING_INPUT)){
            System.out.print("You cant enter the space type at the head of the line, enter again: ");
            stringInput = scanner.nextLine();
        }
        return stringInput;
    }

    public static String checkAreaSupport(){
        String areaSupport = scanner.nextLine();
        while (!areaSupport.matches(REGEX_QUOC_TE) && !areaSupport.matches(REGEX_TOAN_QUOC)){
            System.out.print("Area support have to 'Toan Quoc' or 'Quoc Te'. enter again: ");
            areaSupport = scanner.nextLine();
        }
        return areaSupport;
    }

    public static String checkFixType(){
        String fixType = scanner.nextLine();
        while (!fixType.matches(REGEX_DA_SUA_CHUA) && !fixType.matches(REGEX_CHUA_SUA_CHUA)){
            System.out.print("Fix type have to 'Da sua chua' or 'Chua sua chua': ");
            fixType = scanner.nextLine();
        }
        return fixType;
    }

}
