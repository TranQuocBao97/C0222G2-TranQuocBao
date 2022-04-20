package case_study.services.implement.facility_implement;

import case_study.models.facility.AbsFacility;
import case_study.models.facility.sub_facility.House;
import case_study.services.IFacilityService;
import case_study.services.IService;

import java.util.*;

public class HouseServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static Map<House,Integer> houseServicesList = new LinkedHashMap<>();
    static Integer usedHouse1=0;
    static Integer usedHouse2=0;
    static Integer usedHouse3=3;
    static {
        houseServicesList.put(new House(4,"80 mét vuông",4,"Có Nhà Bếp",1),usedHouse1);
        houseServicesList.put(new House(5,"100 mét vuông",6,"Có Nhà Bếp, Sân Vườn",2),usedHouse2);
        houseServicesList.put(new House(6,"150 mét vuông",8,"Có Nhà Bếp, Sân Vườn, Nhiều cây cảnh",2),usedHouse3);
    }

    @Override
    public void displayMaintenance() {
//        Set<Map.Entry<House,Integer>> entryList = houseServicesList.entrySet();
        for(Map.Entry<House,Integer> entry : houseServicesList.entrySet()){
            if(entry.getValue()>3){
                System.out.println(entry);
            }
        }
    }

    @Override
    public void add() {
        while (true){
            Set<House> keyHouseList = houseServicesList.keySet();
            System.out.println("-------Add House Menu-------");
            int stt = 0;
            for(Map.Entry<House,Integer> entry : houseServicesList.entrySet()){
                System.out.println(++stt+". "+entry.getKey());
            }
            System.out.print("Select house: ");
            int addHouse = Integer.parseInt(scanner.nextLine());
            switch (addHouse){
                case 1:
                    houseServicesList.put(new House(1,"80 mét vuông",4,"Có Nhà Bếp",1),++usedHouse1);
                    display();
                    facilityService.add();
                    break;
                case 2:
                    houseServicesList.put(new House(2,"100 mét vuông",6,"Có Nhà Bếp, Sân Vườn",2),++usedHouse2);
                    display();
                    facilityService.add();
                    break;
                case 3:
                    houseServicesList.put(new House(3,"150 mét vuông",8,"Có Nhà Bếp, Sân Vườn, Nhiều cây cảnh",2),++usedHouse3);
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
        for(Map.Entry<House,Integer> entry : houseServicesList.entrySet()){
            System.out.println(entry.getKey()+". Used: "+entry.getValue());
        }
    }

    @Override
    public void edit() {

    }
}
