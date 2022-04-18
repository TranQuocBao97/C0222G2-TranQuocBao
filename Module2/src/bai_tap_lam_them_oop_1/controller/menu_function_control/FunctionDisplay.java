package bai_tap_lam_them_oop_1.controller.menu_function_control;

import bai_tap_lam_them_oop_1.service.implement.CarServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.MotorbikeServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.TruckServiceImplement;

import java.util.Scanner;

public class FunctionDisplay {
    Scanner scanner = new Scanner(System.in);
    public void display(){
        System.out.print("Pick Vehicle to Display: ");

        boolean flagMenu2 = true;
        do {
            int pickVehicle = Integer.parseInt(scanner.nextLine());
            switch (pickVehicle){
                case 1:
                    new TruckServiceImplement().display();
                    flagMenu2=false;
                    break;
                case 2:
                    new CarServiceImplement().display();
                    flagMenu2=false;
                    break;
                case 3:
                    new MotorbikeServiceImplement().display();
                    flagMenu2=false;
                    break;
                default:
                    System.out.println("Please Enter right pick number");
            }
        }while (flagMenu2);
    }
}
