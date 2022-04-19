package bai_tap_lam_them_oop_1_fix.service.implement;

import bai_tap_lam_them_oop_1_fix.controller.MainControl;
import bai_tap_lam_them_oop_1_fix.model.sub_vehicle.Truck;
import bai_tap_lam_them_oop_1_fix.service.ITruckService;
import bai_tap_lam_them_oop_1_fix.service.notImplement.CompanyListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckServiceImpl implements ITruckService {
    Scanner scanner = new Scanner(System.in);
    CompanyListService companyListService = new CompanyListService();
    MainControl mainControl = new MainControl();
    static List<Truck> truckList = new ArrayList<>();
    static {
        truckList.add(new Truck("DTY-12121",new CompanyListService().company(1),2015,"Hồng Lâu Mộng","10 tấn"));
        truckList.add(new Truck("HHU-25252",new CompanyListService().company(0),2016,"Lục Lạc Vàng","15 tấn"));
        truckList.add(new Truck("PJU-32112",new CompanyListService().company(0),2016,"Lục Lạc Vàng","15 tấn"));
    }

    @Override
    public void add() {
        System.out.println("----------");
        System.out.print("Add Truck id control: ");
        String id = scanner.nextLine();
        System.out.println("Add Truck company");
        String company = companyListService.pickCompany();
        System.out.print("Add Truck year of product: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Truck owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Add Truck deadWeight: ");
        String deadWeight = scanner.nextLine();

        truckList.add(new Truck(id,company,year,owner,deadWeight));

    }

    @Override
    public void display() {
        for(Truck truck : truckList){
            System.out.println(truck);
        }
    }

    @Override
    public void delete(String id) {
        for (Truck truck : truckList){
            if(truck.getIdControl().equals(id)){
                boolean flag = true;
                System.out.println("----------");
                System.out.println("Are you really want to delete this: ");
                System.out.println(truck);
                System.out.println("1. yes");
                System.out.println("2. no");
                do {
                    System.out.print("Enter : ");
                    int confirm = Integer.parseInt(scanner.nextLine());
                    switch (confirm){
                        case 1:
                            truckList.remove(truck);
                            System.out.println("This truck information got deleted");
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
        for(Truck truck : truckList){
            if(truck.getIdControl().contains(id)){
                System.out.println(truck);
                return true;
            }
        }
        return false;
    }
}
