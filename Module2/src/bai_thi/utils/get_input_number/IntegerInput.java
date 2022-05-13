package bai_thi.utils.get_input_number;

import java.util.Scanner;

public class IntegerInput {
    static Scanner scanner = new Scanner(System.in);
    public static Integer checkIntegerInputOverZero(){
        Integer numberInput;
        while(true){
            try{
                numberInput = Integer.parseInt(scanner.nextLine());
                if(numberInput>0){
                    return numberInput;
                }else {
                    System.out.println("Number need to Negative, try again: ");
                }
            }catch (NumberFormatException e){
                System.out.print("You need enter number type (0-9), try again: ");
            }
        }
    }
}
