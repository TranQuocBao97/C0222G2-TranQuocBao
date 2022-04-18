package bai_tap_lam_them_oop_1.service.implement;


import bai_tap_lam_them_oop_1.controller.MainControl;
import bai_tap_lam_them_oop_1.model.sub_vehicle.Truck;
import bai_tap_lam_them_oop_1.service.notImplement.CompanyListService;
import bai_tap_lam_them_oop_1.service.InterfaceTruckService;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckServiceImplement implements InterfaceTruckService {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Truck> truckList = new ArrayList<>();

    static {
        truckList.add(new Truck(12121,new CompanyListService().company(1),2015,"Hồng Lâu Mộng","10 tấn"));
        truckList.add(new Truck(25252,new CompanyListService().company(0),2016,"Lục Lạc Vàng","15 tấn"));
        truckList.add(new Truck(32112,new CompanyListService().company(0),2016,"Lục Lạc Vàng","15 tấn"));
    }

    @Override
    public void add() {
        System.out.println("----------");
        System.out.print("Add Truck id control: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Add Truck company");
        String company = new CompanyListService().pickCompany();
        System.out.print("Add Truck year of product: ");
        int year = Integer.parseInt(scanner.nextLine());
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
    public void delete(int id) {
        for (Truck truck : truckList){
            if(truck.getIdControl()==id){
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
        for(Truck truck : truckList){
            String truckString = Integer.toString(truck.getIdControl());
            String idString = Integer.toString(id);
            if(truckString.contains(idString)){
                System.out.println(truck);
                return true;
            }
        }
        return false;
    }
}
