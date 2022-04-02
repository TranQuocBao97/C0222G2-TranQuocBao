package ss02_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimUocSoChungLonNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số a: ");
        int a = input.nextInt();
        System.out.println("nhập số b: ");
        int b = input.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a==0||b==0){
            System.out.println("Không có ước chung lớn nhất");
        }
        int max = 0;
        if(a>b){
            max=a;
        }else {
            max=b;
        }
        int ucln = 0;
        for (int i = 1; i < max ; i++) {
            if(a%i==0 && b%i==0){
                ucln=i;
            }
        }
        System.out.println("Ước chung lớn nhất : "+ucln);
    }
}
