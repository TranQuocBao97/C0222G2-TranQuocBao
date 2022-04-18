package bai_tap_lam_them_oop_1.controller.menu_function_control;

import bai_tap_lam_them_oop_1.service.implement.CarServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.MotorbikeServiceImplement;
import bai_tap_lam_them_oop_1.service.implement.TruckServiceImplement;

import java.util.Scanner;

public class FunctionSearch {
    Scanner scanner = new Scanner(System.in);

    public void search(){
        boolean checkSearch = false;
        boolean flag = false;
        System.out.print("Enter your id control to search: ");
        int idControl = Integer.parseInt(scanner.nextLine());
        checkSearch = new TruckServiceImplement().search(idControl);
        if(checkSearch){
            flag = true;
        }
        checkSearch = new CarServiceImplement().search(idControl);
        if(checkSearch){
            flag = true;
        }
        checkSearch = new MotorbikeServiceImplement().search(idControl);
        if(checkSearch){
            flag = true;
        }

        if(!flag){
            System.out.println("Không có phương tiện nào được tìm thấy");
        }

    }
}
