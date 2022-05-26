package test;

import java.util.*;

public class giaithuat {
    public static void main(String[] args) {
        int[][] arg1 = {
                {1, 2, 8, 43},
                {9, 4, 53, 7},
                {11, 6, 4, 0},
                {1, 2, 6, 51}
        };
        Set<Integer> list = new TreeSet<>();
            for (int i = 0; i < arg1.length; i++) {
                for (int j = 0; j < arg1[i].length; j++) {
                    if (songuyento(arg1[i][j])) {
                        list.add(arg1[i][j]);
                    }
                }
            }
        System.out.println(list.toString());
    }
    public static boolean songuyento(int number) {
        if(number<2){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
