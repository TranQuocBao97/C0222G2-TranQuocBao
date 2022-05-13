package bai_thi.controllers;

import bai_thi.services.class_implement.HandPhoneService;
import bai_thi.services.class_implement.RealPhoneService;
import bai_thi.utils.get_input_number.IntegerInput;

import java.util.Scanner;

public class ControllerMenu {
    static Scanner scanner = new Scanner(System.in);
    static RealPhoneService realPhoneService = new RealPhoneService();
    static HandPhoneService handPhoneService = new HandPhoneService();
    public static void displayManageMenu(){
        while (true){
            System.out.println("-----Manage Phone Menu-----");
            System.out.println("1. Add new");
            System.out.println("2. Delete");
            System.out.println("3. Display phone list");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.print("Select: ");
            Integer select = IntegerInput.checkIntegerInputOverZero();
            switch (select){
                case 1:
                    selectPhoneToAdd();
                    break;
                case 2:
                    break;
                case 3:
                    realPhoneService.display();
                    handPhoneService.display();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("please select right number on menu!");
            }
        }

    }

    private static void selectPhoneToAdd() {
        while (true){
            System.out.println("-----Select Phone to Add-----");
            System.out.println("1. RealPhone");
            System.out.println("2. HandPhone");
            System.out.print("Select: ");
            Integer select = IntegerInput.checkIntegerInputOverZero();
            switch (select){
                case 1:
                    realPhoneService.add();
                    return;
                case 2:
                    handPhoneService.add();
                    return;
                default:
                    System.out.println("Please select right number");
            }
        }
    }
}
