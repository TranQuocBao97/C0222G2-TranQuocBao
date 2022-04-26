package ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.services;

import ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.controllers.MenuControllers;
import ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.models.ProductSs17;
import ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.utils.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_PRODUCT = "src/ss17_io_binary_file_and_serialization/bai_tap/quan_li_danh_sach_nhi_phan/data/File_data_product.txt";
    private static List<ProductSs17> productList = new ArrayList<>();
    static {
        productList = ReadAndWriteFile.readFileProduct(FILE_DATA_PRODUCT);
    }

    public void add(){
        while (true){
            try{
                System.out.print("Add id product: ");
                String id = scanner.nextLine();
                System.out.print("Add name product: ");
                String name = scanner.nextLine();
                System.out.print("Add company: ");
                String company = scanner.nextLine();
                System.out.print("Add price: ");
                Integer price = Integer.parseInt(scanner.nextLine());
                System.out.print("Add information: ");
                String information = scanner.nextLine();

                productList.add(new ProductSs17(id,name,company,price,information));

                ReadAndWriteFile.writeFileProduct(FILE_DATA_PRODUCT,productList);
                MenuControllers.mainDisplay();
            }catch (Exception e){
                System.out.println("Another data-type is String, price data-type is Integer");

            }
        }
    }
    public void display(){
        for(ProductSs17 product : productList){
            System.out.println(product);
        }
    }
    public void search(){
        System.out.print("Enter Id to search here: ");
        String id = scanner.nextLine();
        for(ProductSs17 product : productList){
            if(product.getId().contains(id)){
                System.out.println(product);
            }
        }
    }
}
