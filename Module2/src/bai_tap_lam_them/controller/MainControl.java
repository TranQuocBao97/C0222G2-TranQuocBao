package bai_tap_lam_them.controller;

import bai_tap_lam_them.controller.menu_function_control.FunctionAdd;
import bai_tap_lam_them.controller.menu_function_control.FunctionDelete;
import bai_tap_lam_them.controller.menu_function_control.FunctionDisplay;
import bai_tap_lam_them.controller.menu_function_control.FunctionSearch;

import java.util.Scanner;

public class MainControl {
    public static void mainDisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("----------");
            System.out.println("Main Menu: ");
            System.out.println("1. Add vehicle");
            System.out.println("2. Display all vehicles");
            System.out.println("3. Delete vehicle information by 'id control'");
            System.out.println("4. Search vehicle information by 'id control'");
            System.out.println("5. Exit");

            System.out.print("Enter the function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());

            switch (chooseMenu){
                case 1:
                    System.out.println("----------");
                    System.out.println("Add Vehicle Menu");
                    System.out.println("1. Truck");
                    System.out.println("2. Car");
                    System.out.println("3. Motorbike");
                    new FunctionAdd().add();
                    break;
                case 2:
                    System.out.println("----------");
                    System.out.println("Display");
                    System.out.println("Display Vehicle Menu");
                    System.out.println("1. Truck");
                    System.out.println("2. Car");
                    System.out.println("3. Motorbike");
                    new FunctionDisplay().display();
                    break;
                case 3:
                    System.out.println("----------");
                    System.out.println("Delete Menu");
                    new FunctionDelete().delete();
                    break;
                case 4:
                    System.out.println("----------");
                    System.out.println("Search Menu");
                    new FunctionSearch().search();
                    break;
                case 5:
                    System.out.println("----------");
                    System.out.println("The System got exit");
                    flag = false;
                default:
                    System.out.println("----------");
                    System.out.println("Please Enter the right number function");
            }
        }while (flag);
    }
}
