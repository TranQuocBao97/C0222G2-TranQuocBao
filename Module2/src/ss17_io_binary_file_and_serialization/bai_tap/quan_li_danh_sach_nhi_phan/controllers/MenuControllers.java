package ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.controllers;

import ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.services.ProductService;

import java.util.Scanner;

public class MenuControllers {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductService();
    public static void mainDisplay() {
        while (true){
            System.out.println("-------Menu-------");
            System.out.println("1. Add product.");
            System.out.println("2. Display product.");
            System.out.println("3. Search product by id.");
            System.out.println("4. Exit");
            try{
                System.out.print("Select menu: ");
                Integer select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        productService.add();
                        break;
                    case 2:
                        productService.display();
                        break;
                    case 3:
                        productService.search();
                        break;
                    case 4:
                        System.exit(0);
                }
            }catch (Exception e){
                System.out.println("Please enter right number");
            }
        }
    }
}
