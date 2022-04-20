package test.giai_thuat_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class gaithuat2 {
    public static void main(String[] args) {
        String str = "CodegymDaNang";
        String array[] = str.split("");
        String str2 = "";
        for(int i =0 ; i < array.length ; i++){
            if(i==0 && Objects.equals(array[i], array[i].toUpperCase())){
                str2 = array[i].toLowerCase();
                continue;
            }
            if(Objects.equals(array[i], array[i].toUpperCase())){
                str2+=" ";
                str2+=array[i].toLowerCase();
            }else {
                str2 += array[i];
            }

        }
        System.out.println(str2);
    }
}
