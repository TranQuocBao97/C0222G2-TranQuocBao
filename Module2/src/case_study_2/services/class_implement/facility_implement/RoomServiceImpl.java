package case_study_2.services.class_implement.facility_implement;

import case_study_2.models.facility.sub_facility.Room;
import case_study_2.services.IFacilityId;
import case_study_2.services.IMaintenance;
import case_study_2.services.IRoomService;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.select_property_value.RentType;
import case_study_2.utils.take_data_input_by_condition.DataInputWithCondition;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.Map;
import java.util.Scanner;

public class RoomServiceImpl implements IRoomService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_ROOM  = "src/case_study_2/data/File_Data_Room.csv";
    private static final Map<Room,Integer> roomList;
    static {
        roomList = ReadFile.roomListFromFileData(FILE_DATA_ROOM);
    }

    @Override
    public String selectIdFacility() {
        return null;
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
            System.out.println(entry.getKey().toString()+". Time used: "+entry.getValue().toString());
        }
    }

    @Override
    public void edit() {

    }


}
