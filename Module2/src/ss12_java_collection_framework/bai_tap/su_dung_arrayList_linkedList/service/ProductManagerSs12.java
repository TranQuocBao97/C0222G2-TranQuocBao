package ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.service;

import ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.model.ProductSs12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManagerSs12 implements IProductManager{
    static Scanner scanner = new Scanner(System.in);
//    private static ArrayList<ProductSs12> productList = new ArrayList<>();
    private static LinkedList<ProductSs12> productList = new LinkedList<>();

    static {
        productList.add(new ProductSs12(4,"Phồng tôm",10000));
        productList.add(new ProductSs12(1, "Kem", 2000));
        productList.add(new ProductSs12(2, "Nước", 5000));
        productList.add(new ProductSs12(3, "Gạo", 20000));
        productList.add(new ProductSs12(5,"Mì tôm",6000));
    }

    @Override
    public void add() {
        System.out.print("add id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.print("add name: ");
        String name = scanner.nextLine();
        System.out.print("add price: ");
        Integer price = Integer.parseInt(scanner.nextLine());

        productList.add(new ProductSs12(id, name, price));
    }

    @Override
    public void update() {
        System.out.print("Enter id for update: ");
        Integer idUpdate = Integer.parseInt(scanner.nextLine());
        boolean checkIdUpdate = false;
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if ((productList.get(i).getId()).equals(idUpdate)) {
                checkIdUpdate = true;
                index = i;
            }
        }
        if(checkIdUpdate){
            System.out.print("Update name : ");
            String nameUpdate = scanner.nextLine();
            System.out.print("Update price : ");
            Integer priceUpdate = Integer.parseInt(scanner.nextLine());
            productList.get(index).setName(nameUpdate);
            productList.get(index).setPrice(priceUpdate);
//          productList.remove(productList.get(index));
//          productList.add(index, new ProductSs12(idUpdate, nameUpdate, priceUpdate));
        }else {
            System.out.println("this id is not exist to update");
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id for delete: ");
        Integer idDelete = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (ProductSs12 product : productList) {
            if (product.getId().equals(idDelete)) {
                productList.remove(product);
                flagDelete = true;
                break;
            }
        }
        if (flagDelete) {
            System.out.println("deleted");
        } else {
            System.out.println("this id is not exist to delete");
        }
    }

    public void display() {
        for (ProductSs12 product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void search(){
        System.out.print("Enter name of product to search: ");
        String nameSearch = scanner.nextLine();
        for (ProductSs12 product : productList){
            if(product.getName().contains(nameSearch)){
                System.out.println(product);
            }
        }
    }

    @Override
    public void sort(){
        System.out.println("sort by price");
        System.out.println("1. High to low");
        System.out.println("2. low to high");
        boolean flagSort = true;
        do{
            System.out.print("Enter number on menu to sort: ");
            Integer pickSort = Integer.parseInt(scanner.nextLine());
            switch (pickSort){
                case 1:
                    SortHighToLow sortHighToLow = new SortHighToLow();
                    productList.sort(sortHighToLow);
                    display();
                    flagSort=false;
                    break;
                case 2:
                    SortLowToHigh sortLowToHigh = new SortLowToHigh();
                    productList.sort(sortLowToHigh);
                    display();
                    flagSort=false;
                    break;
                default:
                    System.out.println("Please Enter right number");
            }
        }while (flagSort);


    }



}
