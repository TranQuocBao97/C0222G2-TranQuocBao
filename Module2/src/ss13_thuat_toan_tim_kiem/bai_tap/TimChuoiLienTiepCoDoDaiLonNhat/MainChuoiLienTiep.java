package ss13_thuat_toan_tim_kiem.bai_tap.TimChuoiLienTiepCoDoDaiLonNhat;

import java.util.LinkedList;
import java.util.Scanner;

public class MainChuoiLienTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> listMax = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }

            list.add(string.charAt(i));

            if(list.size() > listMax.size()){
                listMax.clear();
                listMax.addAll(list);
            }
        }

        for(Character element: listMax){
            System.out.print(element);
        }
    }
}
