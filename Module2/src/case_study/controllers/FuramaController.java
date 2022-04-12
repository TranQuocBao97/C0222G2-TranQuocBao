package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean confirm = true;
        do {

            System.out.println("Main Menu: \n"+
                    "1. Employee Management\n"+
                    "2. Customer Management\n"+
                    "3. Facility Management\n"+
                    "4. Booking Management\n"+
                    "5. Promotion Management\n"+
                    "6. Exit");
            System.out.print("pick your function: ");
           int pickMenu0 = Integer.parseInt(input.nextLine());
            switch (pickMenu0){
                case 1:
                    boolean flag1 = true;
                    do{
                        System.out.println("Menu 1 Employee Management: \n"+
                                "1. Display list employees\n"+
                                "2. Add new employee\n"+
                                "3. Edit employee\n"+
                                "4. Return main menu");
                        System.out.print("pick function menu Employee: ");
                        int pickMenu1 = Integer.parseInt(input.nextLine());
                        switch (pickMenu1){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag1=false;
                        }
                    }while (flag1);
                    break;
                case 2:
                    boolean flag2 = true;
                    do {
                        System.out.println("Menu 2 Customer Management: \n"+
                                "1. Display list customers\n"+
                                "2. Add new customer\n"+
                                "3. Edit customer\n"+
                                "4. Return main menu");
                        System.out.print("pick function menu Customer: ");
                        int pickMenu2 = Integer.parseInt(input.nextLine());
                        switch (pickMenu2){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag2=false;
                        }
                    }while (flag2);
                    break;
                case 3:
                    boolean flag3 = true;
                    do {
                        System.out.println("Menu 3 Facility Management: \n"+
                                "1. Display list facility\n"+
                                "2. Add new facility\n"+
                                "3. Display list facility maintenance\n"+
                                "4. Return main menu");
                        System.out.print("pick function menu Facility: ");
                        int pickMenu3 = Integer.parseInt(input.nextLine());
                        switch (pickMenu3){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                flag3=false;
                        }
                    }while (flag3);
                    break;
                case 4:
                    boolean flag4 = true;
                    do {
                        System.out.println("Menu 4 Booking Management: \n"+
                                "1. Add new booking\n"+
                                "2. Display list booking\n"+
                                "3. Create new contracts\n"+
                                "4. Display list contracts\n"+
                                "5. Edit contracts\n"+
                                "6. Return main menu");
                        System.out.print("pick function menu Management: ");
                        int pickMenu4 = Integer.parseInt(input.nextLine());
                        switch (pickMenu4){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                flag4=false;
                        }
                    }while (flag4);
                    break;
                case 5:
                    boolean flag5 = true;
                    do {
                        System.out.println("Menu 5 Promotion Management: \n"+
                                "1. Display list customers use service\n"+
                                "2. Display list customers get voucher\n"+
                                "3. Return main menu\n");
                        System.out.print("pick function menu Promotion: ");
                        int pickMenu5 = Integer.parseInt(input.nextLine());
                        switch (pickMenu5){
                            case 1:
                            case 2:
                            case 3:
                                flag5=false;
                        }
                    }while (flag5);
                    break;
                case 6:
                    confirm = false;
                    break;

            }
        }while(confirm);
    }
}
