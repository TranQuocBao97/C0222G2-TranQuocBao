package bai_tap_lam_them_test.service.implement;

import bai_tap_lam_them_test.controller.MainControl;
import bai_tap_lam_them_test.model.Company;
import bai_tap_lam_them_test.model.sub_vehicle.Car;
import bai_tap_lam_them_test.service.ICarService;
import bai_tap_lam_them_test.service.notImplement.CompanyListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarServiceImpl implements ICarService {
    CompanyListService companyListService = new CompanyListService();
    MainControl mainControl = new MainControl();
    Scanner scanner = new Scanner(System.in);
    public static List<Car> carList = new ArrayList<>();

    static{
        carList.add(new Car ("BKH-12150",new CompanyListService().company(0),2020,"Trần Quốc Bảo",6,"Thể thao"));
        carList.add(new Car ("YUH-27410",new CompanyListService().company(1),2019,"Lê Văn Lợi",12,"Du Lịch"));
        carList.add(new Car ("BGH-98666",new CompanyListService().company(2),2021,"Đinh La Lúc",4,"Gia đình"));
        carList.add(new Car ("GTY-11001",new CompanyListService().company(2),2021,"Đinh La Lúc",4,"Gia đình"));
    }

    @Override
    public void add() {
        System.out.println("----------");
        System.out.print("Add Car id control: ");
        String id = scanner.nextLine();
        System.out.println("Add Car company");
        String company = companyListService.pickCompany();
        System.out.print("Add Car year of product: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Car owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Add number seat: ");
        Integer numberSeat = Integer.parseInt(scanner.nextLine());
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
    public void delete(String id) {
        for (Car car :carList){
            if(car.getIdControl().equals(id)){
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
                            System.out.println("This Car information got deleted");
                            mainControl.Display();
                            flag = false;
                            break;
                        case 2:
                            System.out.println("Cancel delete");
                            mainControl.Display();
                            break;
                        default:
                            System.out.println("Please pick right number");
                    }
                }while (flag);
            }
        }
    }

    @Override
    public boolean search(String id) {
        for(Car car : carList){
            if(car.getIdControl().contains(id)){
                System.out.println(car);
                return true;
            }
        }
        return false;
    }
}
