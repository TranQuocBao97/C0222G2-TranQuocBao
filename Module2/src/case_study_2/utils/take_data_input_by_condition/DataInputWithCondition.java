package case_study_2.utils.take_data_input_by_condition;

import java.util.Scanner;

public class DataInputWithCondition {
    private static Scanner scanner = new Scanner(System.in);
    public static Double takeArea() {
        boolean flag = true;
        Double area = 0d;
        do{
            try{
                System.out.print("Add area: ");
                area = Double.parseDouble(scanner.nextLine());
                if(area <30){
                    throw new Exception();
                }
                flag=false;
            }catch (Exception e){
                System.out.println("Area need more than 30");
            }
        }while (flag);
        return area;
    }

    public static Double takePricePerDay(){
        Double pricePerDay = 0d;
        do{
            try{
                System.out.print("Add price per day: ");
                pricePerDay = Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Please Enter price >0");
            }
        }while (pricePerDay<=0);
        return pricePerDay;
    }

    public static Double takePricePerHour(){
        Double pricePerHour = 0d;
        do{
            try {
                System.out.print("Add price per hour: ");
                pricePerHour = Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Please Enter price >0");
            }
        }while (pricePerHour<=0);
        return pricePerHour;
    }

    public static Integer takeNumberFloors(){
        Integer numberFloors = 0;
        do{
            try {
                System.out.print("Add number floors: ");
                numberFloors = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Please Enter number floor >0");
            }
        }while (numberFloors<=0);
        return numberFloors;
    }
}
