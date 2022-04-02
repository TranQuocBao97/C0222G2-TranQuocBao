package ss02_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double money =  1.0;
        double rateByYear = 1.0;
        int month = 1;
        System.out.println("Nhập số tiền bạn muốn gửi: ");
        money = input.nextDouble();
        System.out.println("Nhập số tháng bạn muốn gửi: ");
        month = input.nextInt();
        System.out.println("Nhập lãi xuất của ngân hàng hằng năm: ");
        rateByYear = input.nextDouble();

        double totalInterest = 0;
        for (int i =0;i<month;i++){
            totalInterest += money * (rateByYear/100)/12*month;
        }

        System.out.println("Tiền lãi nhận đc là: "+totalInterest);
    }
}
