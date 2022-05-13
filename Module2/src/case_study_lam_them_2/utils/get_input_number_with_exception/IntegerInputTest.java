package case_study_lam_them_2.utils.get_input_number_with_exception;

import java.util.Scanner;

public class IntegerInputTest {
    static Scanner scanner = new Scanner(System.in);
    public static Integer checkIntegerInput(){
        Integer numberInput;
        while(true){
            try{
                numberInput = Integer.parseInt(scanner.nextLine());
                return numberInput;
            }catch (NumberFormatException e){
                System.out.print("You need enter number type (0-9), try again: ");
            }
        }
    }

}
