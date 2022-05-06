package case_study_2.services.class_implement.facility_implement;

import case_study_2.controllers.controllers_furama.FacilityController;

import case_study_2.models.facility.Facility;
import case_study_2.models.facility.sub_facility.House;
import case_study_2.models.facility.sub_facility.Room;
import case_study_2.models.facility.sub_facility.Villa;
import case_study_2.services.IFacilityId;
import case_study_2.services.IMaintenance;

import case_study_2.services.IFacilityService;
import case_study_2.utils.ReadFile;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class FacilityServiceImpl implements IFacilityService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    HouseServiceImpl houseService = new HouseServiceImpl();
    VillaServiceImpl villaService = new VillaServiceImpl();
    RoomServiceImpl roomService = new RoomServiceImpl();
    static int stt = 0;
    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static final String FILE_DATA_HOUSE = "src/case_study_2/data/File_Data_House.csv";
    private static final Map<House, Integer> houseList;
    private static final String FILE_DATA_ROOM = "src/case_study_2/data/File_Data_Room.csv";
    private static final Map<Room, Integer> roomList;
    private static final String FILE_DATA_VILLA = "src/case_study_2/data/File_Data_Villa.csv";
    private static final Map<Villa, Integer> villaList;


    static {
        villaList = ReadFile.villaListFromFileData(FILE_DATA_VILLA);
        roomList = ReadFile.roomListFromFileData(FILE_DATA_ROOM);
        houseList = ReadFile.houseListFromFileData(FILE_DATA_HOUSE);

        facilityList.putAll(villaList);
        facilityList.putAll(houseList);
        facilityList.putAll(roomList);

    }


    public static Double checkPricePerDay(String idFacility) {
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getKey().getIdFacility().equals(idFacility)) {
                return entry.getKey().getPricePerDay();
            }
        }
        return null;
    }


    public String selectIdFacility() {
        while (true) {
            System.out.println("------select ID facility Menu-------");
            System.out.println("1. Booking villa");
            System.out.println("2. Booking house");
            System.out.println("3. Booking room");
            try {
                System.out.print("Select to get ID facility: ");
                int selectID = Integer.parseInt(scanner.nextLine());
                switch (selectID) {
                    case 1:
                        return villaService.selectIdFacility();
                    case 2:
                        return houseService.selectIdFacility();
                    case 3:
                        return roomService.selectIdFacility();
                }
            } catch (Exception e) {
                System.out.println("Please select right number on menu");
            }
        }
    }

    @Override
    public void displayMaintenance() {
        villaService.displayMaintenance();
        houseService.displayMaintenance();
        roomService.displayMaintenance();
    }

    @Override
    public void add() {
        while (true) {
            System.out.println("------select facility Menu-------");
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new room");
            System.out.println("4. Back to menu");
            try {
                System.out.print("Select to add: ");
                int selectAdd = Integer.parseInt(scanner.nextLine());
                switch (selectAdd) {
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
            } catch (Exception e) {
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
