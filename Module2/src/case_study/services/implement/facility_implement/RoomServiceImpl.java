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
    static Integer usedRoom3=4;

    static {
       roomServiceList.put(new Room(7,"25 mét vuông",400000,"Nước uống chào mừng","hướng thành phố"),usedRoom1);
       roomServiceList.put(new Room(8,"30 mét vuông",500000,"Nước uống chào mừng","hướng núi"),usedRoom2);
       roomServiceList.put(new Room(9,"35 mét vuông",600000,"Nước uống chào mừng","hướng vườn"),usedRoom3);
    }


    public Integer checkPriceRoom(String informationFacility){
        Integer price = 0;
        for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
            if(entry.getKey().toString().equals(informationFacility)){
                price =  entry.getKey().getPrice();
            }
        }
        return price;
    }

    public String select(Integer pick){
        String roomInformation = null;
        for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
            if(entry.getKey().getIdFacility().equals(pick)){
                roomInformation = entry.getKey().toString();
            }
        }
        return roomInformation;
    }

    @Override
    public void displayMaintenance() {
        for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
            if(entry.getValue()>5){
                System.out.println(entry.getKey()+" | Used time: "+entry.getValue());
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
            System.out.print("Select room: ");
            int addRoom = Integer.parseInt(scanner.nextLine());
            switch (addRoom){
                case 1:
                    roomServiceList.put(new Room(7,"25 mét vuông",1,"Nước uống chào mừng","hướng thành phố"),++usedRoom1);
                    display();
                    facilityService.add();
                    break;
                case 2:
                    roomServiceList.put(new Room(8,"30 mét vuông",1,"Nước uống chào mừng","hướng núi"),++usedRoom2);
                    display();
                    facilityService.add();
                    break;
                case 3:
                    roomServiceList.put(new Room(9,"35 mét vuông",1,"Nước uống chào mừng","hướng vườn"),++usedRoom3);
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
        System.out.println("-------show data room-------");
        for(Map.Entry<Room,Integer> entry : roomServiceList.entrySet()){
            System.out.println(entry.getKey()+" | Used time: "+entry.getValue());
        }
    }

    @Override
    public void edit() {

    }
}
