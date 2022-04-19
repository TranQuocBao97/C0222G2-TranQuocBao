package ss13_thuat_toan_tim_kiem.bai_tap.TimChuoiTangDanCoDoDaiLonNhat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainChuoiTangDan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi : ");
        String string = scanner.nextLine();

        LinkedList<Character> listMax = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i+1; j < string.length(); j++) {
                if(string.charAt(j) > list.getLast()){
                    list.add(string.charAt(j));
                }
            }
            if(list.size()>listMax.size()){
                listMax.clear();
                listMax.addAll(list);
            }
            list.clear();
        }


        for(Character element: listMax){
            System.out.print(element);
        }
    }
}
