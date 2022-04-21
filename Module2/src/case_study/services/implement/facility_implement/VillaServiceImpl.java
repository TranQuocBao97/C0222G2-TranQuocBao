package case_study.services.implement.facility_implement;

import case_study.models.facility.sub_facility.House;
import case_study.models.facility.sub_facility.Villa;
import case_study.services.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VillaServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static Map<Villa,Integer> villaServiceList = new LinkedHashMap<>();
    static Integer usedVilla1=0;
    static Integer usedVilla2=0;
    static Integer usedVilla3=0;

    static {
        villaServiceList.put(new Villa(1,"80 mét vuông",3000000,"Hồ bơi","Cạnh khu vui chơi"),usedVilla1);
        villaServiceList.put(new Villa(2,"100 mét vuông",4000000,"Hồ bơi, sân vườn","Gần biển Mỹ Khê"),usedVilla2);
        villaServiceList.put(new Villa(3,"150 mét vuông",5000000,"Hồ bơi, sân vườn hoa có BBQ nướng","Trên dốc núi, phía dưới có biển"),usedVilla3);
    }

    public String select(Integer pick){
        String villaInformation = null;
        for(Map.Entry<Villa,Integer> entry : villaServiceList.entrySet()){
            if(entry.getKey().getIdFacility().equals(pick)){
                villaInformation = entry.getKey().toString();
            }
        }
        return villaInformation;
    }

    @Override
    public void displayMaintenance() {
        for(Map.Entry<Villa,Integer> entry : villaServiceList.entrySet()){
            if(entry.getValue()>5){
                System.out.println(entry.getKey()+" | Used time: "+entry.getValue());
            }
        }
    }

    @Override
    public void add() {
        while (true){
            Set<Villa> keyHouseList = villaServiceList.keySet();
            System.out.println("-------Add Villa Menu-------");
            int stt = 0;
            for(Map.Entry<Villa,Integer> entry : villaServiceList.entrySet()){
                System.out.println(++stt+". "+entry.getKey());
            }
            System.out.print("Select villa: ");
            int addVilla = Integer.parseInt(scanner.nextLine());
            switch (addVilla){
                case 1:
                    villaServiceList.put(new Villa(1,"80 mét vuông",4,"Hồ bơi","Cạnh khu vui chơi"),++usedVilla1);
                    display();
                    facilityService.add();
                    break;
                case 2:
                    villaServiceList.put(new Villa(2,"100 mét vuông",6,"Hồ bơi, sân vườn","Gần biển Mỹ Khê"),++usedVilla2);
                    display();
                    facilityService.add();
                    break;
                case 3:
                    villaServiceList.put(new Villa(3,"150 mét vuông",8,"Hồ bơi, sân vườn hoa có BBQ nướng","Trên dốc núi, phía dưới có biển"),++usedVilla3);
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
        System.out.println("-------show data villa-------");
        for(Map.Entry<Villa,Integer> entry : villaServiceList.entrySet()){
            System.out.println(entry.getKey()+" | Used time: "+entry.getValue());
        }
    }

    @Override
    public void edit() {

    }
}
