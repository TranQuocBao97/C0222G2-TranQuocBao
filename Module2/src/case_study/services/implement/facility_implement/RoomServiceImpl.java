package case_study.services.implement.facility_implement;

import case_study.controllers.managementController.FacilityController;
import case_study.models.facility.sub_facility.House;
import case_study.models.facility.sub_facility.Room;
import case_study.services.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static Map<Room,Integer> roomServiceList = new LinkedHashMap<>();
    static Integer usedRoom1=0;
    static Integer usedRoom2=0;
    static Integer usedRoom3=0;

    static {
       roomServiceList.put(new Room(7,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),usedRoom1);
       roomServiceList.put(new Room(8,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),usedRoom2);
       roomServiceList.put(new Room(9,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),usedRoom3);
    }

    @Override
    public void displayMaintenance() {
        for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
            if(entry.getValue()>3){
                System.out.println(entry);
            }
        }
    }

    @Override
    public void add() {
        while (true){
            Set<Room> keyRoomList = roomServiceList.keySet();
            System.out.println("-------Add Room Menu-------");
            int stt = 0;
            for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
                System.out.println(++stt+". "+entry.getKey());
            }
            System.out.print("Select house: ");
            int addHouse = Integer.parseInt(scanner.nextLine());
            switch (addHouse){
                case 1:
                    roomServiceList.put(new Room(7,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),++usedRoom1);
                    display();
                    facilityService.add();
                    break;
                case 2:
                    roomServiceList.put(new Room(8,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),++usedRoom2);
                    display();
                    facilityService.add();
                    break;
                case 3:
                    roomServiceList.put(new Room(9,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),++usedRoom3);
                    display();
                    facilityService.add();
                    break;
                default:
                    System.out.println("Please enter the right number");
            }
        }
    }

    @Override
    public void display() {
        System.out.println("-------show data house-------");
    }

    @Override
    public void edit() {

    }
}
