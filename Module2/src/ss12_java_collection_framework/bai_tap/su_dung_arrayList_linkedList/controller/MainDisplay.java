package ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.controller;

import ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.service.IProductManager;
import ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.service.ProductManagerSs12;

import java.util.Scanner;

public class MainDisplay {
    static Scanner scanner = new Scanner(System.in);
//    static ProductManagerSs12 productManagerSs12 = new ProductManagerSs12();
    static IProductManager iProductManager = new ProductManagerSs12();
    public static void mainMenu() {
        while (true){
            System.out.println("--------------------------");
            System.out.println("welcome - This is Menu of program");
            System.out.println("1. Add product");
            System.out.println("2. Update product by id");
            System.out.println("3. Delete product by id");
            System.out.println("4. Display all product");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort");
            System.out.println("7. Exit");
            System.out.print("Enter the function: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    iProductManager.add();
                    break;
                case 2:
                    iProductManager.update();
                    break;
                case 3:
                    iProductManager.delete();
                    break;
                case 4:
                    iProductManager.display();
                    break;
                case 5:
                    iProductManager.search();
                    break;
                case 6:
                    iProductManager.sort();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter right number on menu");
            }
        }
    }

}
