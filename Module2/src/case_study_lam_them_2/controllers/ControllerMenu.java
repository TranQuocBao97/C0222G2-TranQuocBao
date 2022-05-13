package case_study_lam_them_2.controllers;

import case_study_lam_them_2.utils.get_input_number_with_exception.IntegerInputTest;

import java.util.Scanner;

public class ControllerMenu {
    static Scanner scanner = new Scanner(System.in);
    public static void display(){
        while(true){
            System.out.println("-----Welcome To Student Manage Menu-----");
            System.out.println("1. Add menu");
            System.out.println("2. Delete menu");
            System.out.println("3. Display menu");
            System.out.println("4. Search menu");
            System.out.println("5. Exit");
            System.out.print("Select menu: ");
            Integer select = IntegerInputTest.checkIntegerInput();
            switch (select){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
            }
        }


    }
}
