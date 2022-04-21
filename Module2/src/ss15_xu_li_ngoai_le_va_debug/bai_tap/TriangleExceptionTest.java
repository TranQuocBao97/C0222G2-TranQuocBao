package ss15_xu_li_ngoai_le_va_debug.bai_tap;



import java.util.Scanner;

public class TriangleExceptionTest {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            System.out.print("Nhập cạnh 1: ");
            Double side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh 2: ");
            Double side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh 3: ");
            Double side3 = Double.parseDouble(scanner.nextLine());
            if(side1>0 && side2>0 && side3>0 && side1+side2>side3 && side2+side3>side1 && side1+side3>side2){
                System.out.println("Tam giác hợp lệ");
            } else {
                throw new Exception("three sides is not able to make the triangle");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
