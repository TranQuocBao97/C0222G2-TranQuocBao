package ss15_xu_li_ngoai_le_va_debug.bai_tap;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainTriangle {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        boolean flag;
        do {
            flag = false;
            System.out.print("Nhập cạnh 1: ");
            Double edge1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh 2: ");
            Double edge2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh 3: ");
            Double edge3 = Double.parseDouble(scanner.nextLine());
            try{
                new Triangle(edge1,edge2,edge3);
            }catch (Exception e){
                e.printStackTrace();
                Thread.sleep(1000);
                flag = true;
            }
        }while (flag);
    }
}
