package test.demo_list_student;

import java.util.*;

public class testagain {
    public static void main(String[] args) {
        String test = "abcbdcef";
        String[] arr = test.split("");
        Set<String> list = new TreeSet<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list,arr);
        int countArray = 0;
        for(String s : list){
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if(s.equals(arr[i])){
                    ++count;
                }
            }
            if(count>=2){
                list2.add(s);
                countArray++;
            }
        }
        String[] out = new String[countArray];
        out = list2.toArray(out);
        System.out.println(Arrays.toString(out));
    }
}
