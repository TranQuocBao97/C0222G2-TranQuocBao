package ss01_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class BaiTapChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate =  23000;
        System.out.print("nhập usd : ");
        float getUsd = scanner.nextFloat();

        float vndChanged = (float) rate*getUsd;
        System.out.printf(" = %.0f vnd",vndChanged);

    }
}
