package ss02_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int soNguyenTo = 2;
        System.out.print("Dãy số Nguyên Tố nhỏ hơn 100: ");
        while (soNguyenTo<=100){
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
            }
            soNguyenTo++;
        }
    }
}
