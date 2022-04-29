package case_study_2.utils.take_data_input_by_regex;

import java.util.Scanner;

public class RegexService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_ID_VILLA = "^SVVL-[\\d]{4}$";
    private static final String REGEX_ID_HOUSE = "^SVHO-[\\d]{4}$";
    private static final String REGEX_ID_ROOM = "^SVRO-[\\d]{4}$";
    private static final String REGEX_NAME_FACILITY = "^[A-Z][a-z\\d]+$";
    private static final String REGEX_AREA_POOL = "^(30\\.[0]*[1-9]+)|(([3-9][1-9])(\\.?[\\d]+)?)|([1-9][\\d][\\d]+(\\.?[\\d]+)?)$";
    private static final String REGEX_DATE_TIME = "^((0[1-9])|([12][0-9])|([3][01]))\\/(([0][1-9])|([1][0-2]))\\/([1-9][0-9]{3})$";

    public static String checkIdVilla(String id){
        while (!id.matches(REGEX_ID_VILLA)){
            System.out.println("SVVL-YYYY, (YYYY 0-9)");
            System.out.print("Please add id villa again: ");
            id = scanner.nextLine();
        }
        return id;
    }
    public static String checkIdHouse(String id){
        while (!id.matches(REGEX_ID_HOUSE)){
            System.out.println("SVHO-YYYY, (YYYY 0-9)");
            System.out.print("Please add id house again: ");
            id = scanner.nextLine();
        }
        return id;
    }
    public static String checkIdRoom(String id){
        while (!id.matches(REGEX_ID_ROOM)){
            System.out.println("SVRO-YYYY, (YYYY 0-9)");
            System.out.print("Please add id room again: ");
            id = scanner.nextLine();
        }
        return id;
    }
    public static String checkNameFacility(String name){
        while (!name.matches(REGEX_NAME_FACILITY)){
            System.out.println("Uppercase first letter, The following letters are lowercase");
            System.out.print("Please add name facility again: ");
            name = scanner.nextLine();
        }
        return name;
    }
    public static String checkAreaPool(String area){
        while (!area.matches(REGEX_AREA_POOL)){
            System.out.println("Area need to be a real number");
            System.out.print("Please add area again: ");
            area = scanner.nextLine();
        }
        return area;
    }
    public static String checkDateTimeFormat(String date){
        while(!date.matches(REGEX_DATE_TIME)){
            System.out.println("DD/MM/YYYY");
            System.out.print("Please add date time again: ");
            date = scanner.nextLine();
        }
        return date;
    }

}
