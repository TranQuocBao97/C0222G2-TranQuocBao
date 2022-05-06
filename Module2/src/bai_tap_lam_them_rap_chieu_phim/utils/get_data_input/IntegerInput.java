package bai_tap_lam_them_rap_chieu_phim.utils.get_data_input;

import java.util.Scanner;

public class IntegerInput {
    static Scanner scanner = new Scanner(System.in);
    public static Integer getIntegerInput(){
        Integer numberInput = null;
        while (true){
            try{
                numberInput = Integer.parseInt(scanner.nextLine());
                return numberInput;
            }catch (Exception e){
                System.out.print("Please Enter Number Type Again: ");
            }
        }
    }
}
