package case_study_2.services.class_implement.facility_implement;

import case_study_2.controllers.controllers_furama.FacilityController;

import case_study_2.services.IFacilityId;
import case_study_2.services.IMaintenance;

import case_study_2.services.IFacilityService;


import java.util.Scanner;


public class FacilityServiceImpl implements IFacilityService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    HouseServiceImpl houseService = new HouseServiceImpl();
    VillaServiceImpl villaService = new VillaServiceImpl();
    RoomServiceImpl roomService = new RoomServiceImpl();






    public String selectIdFacility(){
        while (true){
            System.out.println("------select ID facility Menu-------");
            System.out.println("1. Booking villa");
            System.out.println("2. Booking house");
            System.out.println("3. Booking room");
            try{
                System.out.print("Select to get ID facility: ");
                int selectID = Integer.parseInt(scanner.nextLine());
                switch (selectID){
                    case 1:
                        return villaService.selectIdFacility();
                    case 2:
                        return houseService.selectIdFacility();
                    case 3:
                        return roomService.selectIdFacility();
                }
            }catch (Exception e){
                System.out.println("Please select right number on menu");
            }
        }
    }

    @Override
    public void displayMaintenance(){
        villaService.displayMaintenance();
        houseService.displayMaintenance();
        roomService.displayMaintenance();
    }

    @Override
    public void add() {
        while (true){
            System.out.println("------select facility Menu-------");
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new room");
            System.out.println("4. Back to menu");
            try{
                System.out.print("Select to add: ");
                int selectAdd = Integer.parseInt(scanner.nextLine());
                switch (selectAdd){
                    case 1:
                        villaService.add();
                        break;
                    case 2:
                        houseService.add();
                        break;
                    case 3:
                        roomService.add();
                        break;
                    case 4:
                        FacilityController.facilityMenu();
                }
            }catch (Exception e){
                System.out.println("Please select right number on menu");
            }
        }
    }


    @Override
    public void display() {
        villaService.display();
        houseService.display();
        roomService.display();
    }

    @Override
    public void edit() {

    }
}
