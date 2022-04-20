package case_study.services.implement.facility_implement;


import case_study.controllers.managementController.FacilityController;
import case_study.models.facility.AbsFacility;
import case_study.models.facility.sub_facility.House;
import case_study.services.IFacilityService;
import case_study.services.IService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static HouseServiceImpl houseService = new HouseServiceImpl();
    private static RoomServiceImpl roomService = new RoomServiceImpl();
    private static VillaServiceImpl villaService = new VillaServiceImpl();



    public void add() {
        while (true){
            System.out.println("-------Add new facility Menu-------");
            System.out.println("1. Add new villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Back to Menu");
            System.out.print("Select add: ");
            int addNewFacility = Integer.parseInt(scanner.nextLine());
            switch (addNewFacility){
                case 1:
                    break;
                case 2:
                    houseService.add();
                    break;
                case 3:
                    break;
                case 4:
                    FacilityController.facilityMenu();
            }

        }

    }


    public void display() {
        houseService.display();
    }

    @Override
    public void edit() {

    }


    @Override
    public void displayMaintenance() {
        houseService.displayMaintenance();
    }
}
