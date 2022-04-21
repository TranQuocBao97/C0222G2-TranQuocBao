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


    public String select(Integer pick){
        String facilityInformation = null;
        if(villaService.select(pick)!=null){
            facilityInformation = villaService.select(pick);
        }
        if(houseService.select(pick)!=null){
            facilityInformation = houseService.select(pick);
        }
        if(roomService.select(pick)!=null){
            facilityInformation = roomService.select(pick);
        }
        return  facilityInformation;
    }
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

        }

    }

    public void display() {
        villaService.display();
        houseService.display();
        roomService.display();
    }

    @Override
    public void edit() {

    }


    @Override
    public void displayMaintenance() {
        System.out.println("used more than 3 time will need to maintenance");
        villaService.displayMaintenance();
        houseService.displayMaintenance();
        roomService.displayMaintenance();
    }
}
