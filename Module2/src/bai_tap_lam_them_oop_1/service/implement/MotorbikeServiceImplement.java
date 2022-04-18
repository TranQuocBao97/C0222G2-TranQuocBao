package bai_tap_lam_them_oop_1.service.implement;

import bai_tap_lam_them_oop_1.controller.MainControl;
import bai_tap_lam_them_oop_1.model.sub_vehicle.Motorbike;
import bai_tap_lam_them_oop_1.service.notImplement.CompanyListService;
import bai_tap_lam_them_oop_1.service.InterfaceMotorbikeService;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorbikeServiceImplement implements InterfaceMotorbikeService {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Motorbike> motorbikeList = new ArrayList<>();

    static {
        motorbikeList.add(new Motorbike(75813,new CompanyListService().company(2),2017,"Nguyễn Đông Du",175));
        motorbikeList.add(new Motorbike(42813,new CompanyListService().company(0),2015,"Trần Lục Lạc",250));
        motorbikeList.add(new Motorbike(52115,new CompanyListService().company(0),2015,"Trần Lục Lạc",250));
    }

    @Override
    public void add() {
        System.out.print("Add Motorbike id control: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Add Motorbike company");
        String company = new CompanyListService().pickCompany();
        System.out.print("Add Motorbike year of product: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Motorbike owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Add Motorbike power: ");
        int power = Integer.parseInt(scanner.nextLine());

        motorbikeList.add(new Motorbike(id,company,year,owner,power));
    }

    @Override
    public void display() {
        for(Motorbike motorbike: motorbikeList){
            System.out.println(motorbike);
        }
    }

    @Override
    public void delete(int id) {
        for (Motorbike motorbike : motorbikeList){
            if(motorbike.getIdControl()==id){
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
        for(Motorbike motorbike : motorbikeList){
            String motorbikeString = Integer.toString(motorbike.getIdControl());
            String idString = Integer.toString(id);
            if(motorbikeString.contains(idString)){
                System.out.println(motorbike);
                return true;
            }
        }
        return false;
    }
}
