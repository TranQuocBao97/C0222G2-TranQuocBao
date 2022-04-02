package ss02_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố muốn hiển thị ra màn hình: ");
        int number = input.nextInt();
        int count = 0;
        int soNguyenTo = 2;
        System.out.print("Dãy số Nguyên Tố : ");
        while (count<number){
            boolean confirm =  true;
            for (int j = 2; j <= Math.sqrt(soNguyenTo) ; j++) {
                if (soNguyenTo % j == 0) {
                    confirm = false;
                    break;
                }
            }
            if(confirm){
                System.out.print(soNguyenTo+" ");
                soNguyenTo++;
                count++;
            }
            soNguyenTo++;
        }
    }
}
