package case_study_2.services.class_implement.facility_implement;

import case_study_2.models.facility.sub_facility.House;
import case_study_2.services.IFacilityId;
import case_study_2.services.IHouseService;
import case_study_2.services.IMaintenance;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.select_property_value.RentType;
import case_study_2.utils.take_data_input_by_condition.DataInputWithCondition;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.Map;
import java.util.Scanner;

public class HouseServiceImpl implements IHouseService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_HOUSE  = "src/case_study_2/data/File_Data_House.csv";
    private static final Map<House,Integer> houseList;

    static {
        houseList = ReadFile.houseListFromFileData(FILE_DATA_HOUSE);
    }

    @Override
    public String selectIdFacility() {
        return null;
    }


    @Override
    public void displayMaintenance() {
        for (Map.Entry<House,Integer> entry : houseList.entrySet()){
            if(entry.getValue()>4){
                System.out.println(entry.getKey().toString()+". Time used: "+entry.getValue().toString());
            }
        }
    }

    @Override
    public void add() {
        System.out.print("Add id House: ");
        String idFacility  = RegexService.checkIdHouse(scanner.nextLine());
        System.out.print("Add name: ");
        String name = RegexService.checkNameFacility(scanner.nextLine());
        Double area = DataInputWithCondition.takeArea();
        Double pricePerDay = DataInputWithCondition.takePricePerDay();
        Double pricePerHour = DataInputWithCondition.takePricePerHour();
        String typeRent = RentType.selectRent();
        System.out.print("Add type Facility: ");
        String typeFacility = RegexService.checkNameFacility(scanner.nextLine());
        Integer numberFloors = DataInputWithCondition.takeNumberFloors();

        houseList.put(new House(idFacility,name,area,pricePerDay,pricePerHour,typeRent,typeFacility,numberFloors),0);
        WriteFile.writeHouseListToCsv(FILE_DATA_HOUSE,houseList,false);
    }

    @Override
    public void display() {
        for (Map.Entry<House,Integer> entry : houseList.entrySet()){
            System.out.println(entry.getKey().toString()+". Time used: "+entry.getValue().toString());
        }
    }

    @Override
    public void edit() {

    }


}
