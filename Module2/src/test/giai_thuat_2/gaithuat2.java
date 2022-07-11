package test.giai_thuat_2;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.*;

public class gaithuat2 {
    public static boolean checkDateFormat(String dateString){
        boolean flag = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try{
            Date date = simpleDateFormat.parse(dateString);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.println(checkDateFormat("02-02-2000"));

        
        String str = "CodegymDaNang";
        char test = 65;
        System.out.println(str.charAt(1)+0);
        System.out.println(test);
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
