package case_study_2.services.class_implement.facility_implement;

import case_study_2.models.facility.sub_facility.House;
import case_study_2.models.facility.sub_facility.Room;
import case_study_2.models.facility.sub_facility.Villa;
import case_study_2.services.IFacilityId;
import case_study_2.services.IMaintenance;
import case_study_2.services.IRoomService;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.select_property_value.RentType;
import case_study_2.utils.take_data_input_by_condition.DataInputWithCondition;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class RoomServiceImpl implements IRoomService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_ROOM  = "src/case_study_2/data/File_Data_Room.csv";
    private static final Map<Room,Integer> roomList;
    static {
        roomList = ReadFile.roomListFromFileData(FILE_DATA_ROOM);
    }



    public static void countUseInMonth(String idFacilityForCheck ,Integer useTime){
        for(Map.Entry<Room,Integer> entry : roomList.entrySet()){
            if(entry.getKey().getIdFacility().equals(idFacilityForCheck)){
                entry.setValue(useTime);
                WriteFile.writeRoomListToCsv(FILE_DATA_ROOM,roomList,false);
            }
        }
    }

    @Override
    public String selectIdFacility() {
        while (true){
            try{
                int stt = 0;
                for (Map.Entry<Room,Integer> entry : roomList.entrySet()){
                    System.out.println("STT. "+(++stt)+": "+entry.getKey().toString()+". Time used: "+entry.getValue().toString());
                }
                System.out.print("Select Id room by STT: ");
                int select = Integer.parseInt(scanner.nextLine());
                int checkSelect = 1;
                for(Map.Entry<Room,Integer> entry : roomList.entrySet()){
                    if(select==(checkSelect++)){
                        return entry.getKey().getIdFacility();
                    }
                }
            }catch (Exception e){
                System.out.println("Please Enter right number to select");
            }
        }
    }

    @Override
    public void displayMaintenance() {
        for(Map.Entry<Room,Integer> entry: roomList.entrySet()){
            if(entry.getValue()>4){
                System.out.println(entry.getKey().toString()+". Time used: "+entry.getValue().toString());
            }
        }
    }

    @Override
    public void add() {
        System.out.print("Add id Room: ");
        String idFacility  = RegexService.checkIdRoom(scanner.nextLine());
        System.out.print("Add name: ");
        String name = RegexService.checkNameFacility(scanner.nextLine());
        Double area = DataInputWithCondition.takeArea();
        Double pricePerDay = DataInputWithCondition.takePricePerDay();
        Double pricePerHour = DataInputWithCondition.takePricePerHour();
        String typeRent = RentType.selectRent();
        System.out.print("Add bonus information: ");
        String bonus = scanner.nextLine();

        roomList.put(new Room(idFacility,name,area,pricePerDay,pricePerHour,typeRent,bonus),0);
        WriteFile.writeRoomListToCsv(FILE_DATA_ROOM,roomList,false);
    }

    @Override
    public void display() {
        for(Map.Entry<Room,Integer> entry: roomList.entrySet()){
            System.out.println("STT. "+(++FacilityServiceImpl.stt)+": "+entry.getKey().toString()+". Time used: "+entry.getValue().toString());
        }
    }

    @Override
    public void edit() {

    }


}
