package ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.utils;

import ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.models.ProductSs17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<ProductSs17> readFileProduct(String fileDataProduct){
        List<ProductSs17> productList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(fileDataProduct);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<ProductSs17>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println("File is empty");
        }
        return productList;
    }

    public static void writeFileProduct(String fileDataProduct, List<ProductSs17> productList){
        try{
            FileOutputStream fos = new FileOutputStream(fileDataProduct);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            fos.close();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
