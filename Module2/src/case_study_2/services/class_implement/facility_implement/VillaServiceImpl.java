package case_study_2.services.class_implement.facility_implement;

import case_study_2.models.facility.sub_facility.House;
import case_study_2.models.facility.sub_facility.Villa;
import case_study_2.services.IFacilityId;
import case_study_2.services.IMaintenance;
import case_study_2.services.IVillaService;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.select_property_value.RentType;
import case_study_2.utils.take_data_input_by_condition.DataInputWithCondition;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class VillaServiceImpl implements IVillaService, IMaintenance, IFacilityId {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_VILLA = "src/case_study_2/data/File_Data_Villa.csv";
    private static final Map<Villa,Integer> villaList;
    static {
        villaList = ReadFile.villaListFromFileData(FILE_DATA_VILLA);
    }



    public static void countUseInMonth(String idFacilityForCheck, Integer useTime){
        for(Map.Entry<Villa,Integer> entry : villaList.entrySet()){
            if(Objects.equals(entry.getKey().getIdFacility(), idFacilityForCheck)){
                entry.setValue(useTime);
                WriteFile.writeVillaListToCsv(FILE_DATA_VILLA,villaList,false);
            }
        }
    }


    @Override
    public String selectIdFacility() {
       while (true){
           try{
               int stt = 0;
               for (Map.Entry<Villa,Integer> entry : villaList.entrySet()){
                   System.out.println("STT. "+(++stt)+": "+entry.getKey().toString()+". Time used: "+entry.getValue().toString());
               }
               System.out.print("Select Id facility by STT: ");
               int select = Integer.parseInt(scanner.nextLine());
               int checkSelect = 1;
               for(Map.Entry<Villa,Integer> entry : villaList.entrySet()){
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
        for (Map.Entry<Villa,Integer> entry : villaList.entrySet()){
            if(entry.getValue()>4){
                System.out.println(entry.getKey().toString()+". Time used: "+entry.getValue().toString());
            }
        }
    }

    @Override
    public void add() {
        System.out.print("Add id Villa: ");
        String idFacility  = RegexService.checkIdVilla(scanner.nextLine());
        System.out.print("Add name: ");
        String name = RegexService.checkNameFacility(scanner.nextLine());
        Double area = DataInputWithCondition.takeArea();
        Double pricePerDay = DataInputWithCondition.takePricePerDay();
        Double pricePerHour = DataInputWithCondition.takePricePerHour();
        String typeRent = RentType.selectRent();
        System.out.print("Add type Facility: ");
        String typeFacility = RegexService.checkNameFacility(scanner.nextLine());
        Integer numberFloors = DataInputWithCondition.takeNumberFloors();
        System.out.print("Add area pool: ");
        String areaPool = RegexService.checkAreaPool(scanner.nextLine());

        villaList.put(new Villa(idFacility,name,area,pricePerDay,pricePerHour,typeRent,typeFacility,numberFloors,areaPool),0);
        WriteFile.writeVillaListToCsv(FILE_DATA_VILLA,villaList,false);
    }

    @Override
    public void display() {
        for (Map.Entry<Villa,Integer> entry : villaList.entrySet()){
            System.out.println("STT. "+(++FacilityServiceImpl.stt)+": "+entry.getKey().toString()+". Time used: "+entry.getValue().toString());
        }
    }

    @Override
    public void edit() {

    }


}
