package bai_tap_lam_them_oop_1.controller.menu_function_control;

import bai_tap_lam_them_oop_1.service.implement.CarServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.MotorbikeServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.TruckServiceImplement;

import java.util.Scanner;

public class FunctionDelete {
    Scanner scanner = new Scanner(System.in);

    public void delete(){
        System.out.print("Enter your id control to delete: ");
        int idControl = Integer.parseInt(scanner.nextLine());
        new TruckServiceImplement().delete(idControl);
        new CarServiceImplement().delete(idControl);
        new MotorbikeServiceImplement().delete(idControl);
        System.out.println("Your id control is not exist");
    }
}
