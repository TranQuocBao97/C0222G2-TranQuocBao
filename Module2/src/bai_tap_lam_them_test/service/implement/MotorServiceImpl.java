package bai_tap_lam_them_test.service.implement;

import bai_tap_lam_them_test.controller.MainControl;
import bai_tap_lam_them_test.model.sub_vehicle.Car;
import bai_tap_lam_them_test.model.sub_vehicle.Motorbike;
import bai_tap_lam_them_test.model.sub_vehicle.Truck;
import bai_tap_lam_them_test.service.IMotorbikeService;
import bai_tap_lam_them_test.service.notImplement.CompanyListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorServiceImpl implements IMotorbikeService {
    Scanner scanner = new Scanner(System.in);
    CompanyListService companyListService = new CompanyListService();
    MainControl mainControl = new MainControl();
    static List<Motorbike> motorbikeList = new ArrayList<>();

    static {
        motorbikeList.add(new Motorbike("HYU-75813",new CompanyListService().company(2),2017,"Nguyễn Đông Du",175));
        motorbikeList.add(new Motorbike("BGH-42813",new CompanyListService().company(0),2015,"Trần Lục Lạc",250));
        motorbikeList.add(new Motorbike("DGY-52115",new CompanyListService().company(0),2015,"Trần Lục Lạc",250));
    }

    @Override
    public void add() {
        System.out.print("Add Motorbike id control: ");
        String id = scanner.nextLine();
        System.out.println("Add Motorbike company");
        String company = companyListService.pickCompany();
        System.out.print("Add Motorbike year of product: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Motorbike owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Add Motorbike power: ");
        Integer power = Integer.parseInt(scanner.nextLine());

        motorbikeList.add(new Motorbike(id,company,year,owner,power));
    }

    @Override
    public void display() {
        for(Motorbike motorbike: motorbikeList){
            System.out.println(motorbike);
        }
    }

    @Override
    public void delete(String id) {
        for (Motorbike motorbike :motorbikeList){
            if(motorbike.getIdControl().equals(id)){
                boolean flag = true;
                System.out.println("----------");
                System.out.println("Are you really want to delete this: ");
                System.out.println(motorbike);
                System.out.println("1. yes");
                System.out.println("2. no");
                do {
                    System.out.print("Enter : ");
                    int confirm = Integer.parseInt(scanner.nextLine());
                    switch (confirm){
                        case 1:
                            motorbikeList.remove(motorbike);
                            System.out.println("This motorbike information got deleted");
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
        for(Motorbike motorbike : motorbikeList){
            if(motorbike.getIdControl().contains(id)){
                System.out.println(motorbike);
                return true;
            }
        }
        return false;
    }
}
