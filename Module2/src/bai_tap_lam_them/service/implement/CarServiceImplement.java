package bai_tap_lam_them.service.implement;

import bai_tap_lam_them.controller.MainControl;
import bai_tap_lam_them.model.sub_vehicle.Car;
import bai_tap_lam_them.service.notImplement.CompanyListService;
import bai_tap_lam_them.service.InterfaceCarService;

import java.util.ArrayList;
import java.util.Scanner;

public class CarServiceImplement implements InterfaceCarService{
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Car> carList = new ArrayList<>();

    static{
        carList.add(new Car (12150,new CompanyListService().company(0),2020,"Trần Quốc Bảo",6,"Thể thao"));
        carList.add(new Car (27410,new CompanyListService().company(1),2019,"Lê Văn Lợi",12,"Du Lịch"));
        carList.add(new Car (98666,new CompanyListService().company(2),2021,"Đinh La Lúc",4,"Gia đình"));
    }


    @Override
    public void add() {
        System.out.println("----------");
        System.out.print("Add Car id control: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Add Car company");
        String company = new CompanyListService().pickCompany();
        System.out.print("Add Car year of product: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Car owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Add number seat: ");
        int numberSeat = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Car type: ");
        String type = scanner.nextLine();

        carList.add(new Car(id,company,year,owner,numberSeat,type));
    }

    @Override
    public void display() {
        for(Car car : carList){
            System.out.println(car);
        }
    }

    @Override
    public void delete(int id) {
        for (Car car : carList){
           if(car.getIdControl()==id){
               boolean flag = true;
               System.out.println("----------");
               System.out.println("Are you really want to delete this: ");
               System.out.println(car);
               System.out.println("1. yes");
               System.out.println("2. no");
               do {
                   System.out.print("Enter : ");
                   int confirm = Integer.parseInt(scanner.nextLine());
                   switch (confirm){
                       case 1:
                           carList.remove(car);
                           System.out.println("This car information got deleted");
                           MainControl.mainDisplayMenu();
                           flag = false;
                           break;
                       case 2:
                           MainControl.mainDisplayMenu();
                           break;
                       default:
                           System.out.println("Please pick right number");
                   }
               }while (flag);
           }
        }
    }

    @Override
    public boolean search(int id) {
        for(Car car : carList){
            if(car.getIdControl()==id){
                System.out.println(car);
                return true;
            }
        }
        return false;
    }
}
