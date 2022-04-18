package bai_tap_lam_them_oop_1.service.notImplement;

import bai_tap_lam_them_oop_1.model.Company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyListService {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Company> companyList = new ArrayList<>();

    static {
        companyList.add(new Company(524,"Honda","Japan"));
        companyList.add(new Company(145,"Tesla","American"));
        companyList.add(new Company(754,"Mercedes","Germany"));
    }

    public String pickCompany() {
        System.out.println("1. " + companyList.get(0).getNameCompany());
        System.out.println("2. " + companyList.get(1).getNameCompany());
        System.out.println("3. " + companyList.get(2).getNameCompany());
        boolean flag = true;
        String companyReturn = null;
        do {
            System.out.print("Pick company to add: ");
            int pick = Integer.parseInt(scanner.nextLine());
            switch (pick) {
                case 1:
                    companyReturn = companyList.get(0).toString();
                    flag=false;
                    break;
                case 2:
                    companyReturn = companyList.get(1).toString();
                    flag=false;
                    break;
                case 3:
                    companyReturn = companyList.get(2).toString();
                    flag=false;
                    break;
                default:
                    System.out.println("----------");
                    System.out.println("Please Enter right pick number");
            }
        } while (flag);
        return companyReturn;
    }

    public String company(int pick){
        int count = 0;
        String companyReturn = null;
        for (Company company : companyList){
            if(count==pick){
                companyReturn = company.toString();
                break;
            }
            count++;
        }
        return companyReturn;
    }
}
