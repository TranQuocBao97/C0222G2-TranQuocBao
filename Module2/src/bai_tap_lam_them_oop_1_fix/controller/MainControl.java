package bai_tap_lam_them_oop_1_fix.controller;


import bai_tap_lam_them_oop_1_fix.service.ICarService;
import bai_tap_lam_them_oop_1_fix.service.IMotorbikeService;
import bai_tap_lam_them_oop_1_fix.service.ITruckService;
import bai_tap_lam_them_oop_1_fix.service.implement.CarServiceImpl;
import bai_tap_lam_them_oop_1_fix.service.implement.MotorServiceImpl;
import bai_tap_lam_them_oop_1_fix.service.implement.TruckServiceImpl;

import java.util.Scanner;

public class MainControl {
    private Scanner scanner = new Scanner(System.in);
    private static ITruckService iTruckService = new TruckServiceImpl();
    private static ICarService iCarService = new CarServiceImpl();
    private static IMotorbikeService iMotorbikeService = new MotorServiceImpl();


    public void Display() {
        while (true) {
            System.out.println("----------");
            System.out.println("Main Menu: ");
            System.out.println("1. Add vehicle");
            System.out.println("2. Display all vehicles");
            System.out.println("3. Delete vehicle information by 'id control'");
            System.out.println("4. Search vehicle information by 'id control'");
            System.out.println("5. Exit");


            System.out.print("Enter the function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());

            switch (chooseMenu) {
                case 1:
                    pickVehicleToAdd();
                    break;
                case 2:
                    pickVehicleToDisplay();
                    break;
                case 3:
                    deleteVehicleByIdControl();
                    break;
                case 4:
                    searchVehicleByIdControl();
                    break;
                case 5:
                    System.out.println("----------");
                    System.out.println("The System got exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("----------");
                    System.out.println("Please Enter the right number function");
            }


        }
    }




    public void pickVehicleToAdd() {
        System.out.println("----------");
        System.out.println("Add Vehicle Menu");
        System.out.println("1. Truck");
        System.out.println("2. Car");
        System.out.println("3. Motorbike");
        boolean flagPick = true;
        do {
            System.out.print("Pick Vehicle to Add: ");
            int pickAdd = Integer.parseInt(scanner.nextLine());
            switch (pickAdd) {
                case 1:
                    iTruckService.add();
                    flagPick = false;
                    break;
                case 2:
                    iCarService.add();
                    flagPick = false;
                    break;
                case 3:
                    iMotorbikeService.add();
                    flagPick = false;
                    break;
                default:
                    System.out.println("Please Enter right pick number");
            }
        } while (flagPick);

    }

    private void pickVehicleToDisplay() {
        System.out.println("----------");
        System.out.println("Display");
        System.out.println("Display Vehicle Menu");
        System.out.println("1. Truck");
        System.out.println("2. Car");
        System.out.println("3. Motorbike");
        System.out.print("Pick Vehicle to Display: ");

        boolean flagMenu2 = true;
        do {
            int pickDisplay = Integer.parseInt(scanner.nextLine());
            switch (pickDisplay) {
                case 1:
                    iTruckService.display();
                    flagMenu2 = false;
                    break;
                case 2:
                    iCarService.display();
                    flagMenu2 = false;
                    break;
                case 3:
                    iMotorbikeService.display();
                    flagMenu2 = false;
                    break;
                default:
                    System.out.println("Please Enter right pick number");
            }
        } while (flagMenu2);
    }

    private void deleteVehicleByIdControl() {
        System.out.println("----------");
        System.out.println("Delete Menu");
        System.out.print("Enter your id control to delete: ");
        String idForDelete = scanner.nextLine();
        iTruckService.delete(idForDelete);
        iCarService.delete(idForDelete);
        iMotorbikeService.delete(idForDelete);
        System.out.println("Your id control is not exist");
    }

    private void searchVehicleByIdControl() {
        System.out.println("----------");
        System.out.println("Search Menu");
        boolean checkSearch = false;
        boolean flag = false;
        System.out.print("Enter your id control to search: ");
        String idSeach = scanner.nextLine();
        checkSearch = iTruckService.search(idSeach);
        if(checkSearch){
            flag = true;
        }
        checkSearch = iCarService.search(idSeach);
        if(checkSearch){
            flag = true;
        }
        checkSearch = iMotorbikeService.search(idSeach);
        if(checkSearch){
            flag = true;
        }

        if(!flag){
            System.out.println("Không có phương tiện nào được tìm thấy");
        }
    }



}
