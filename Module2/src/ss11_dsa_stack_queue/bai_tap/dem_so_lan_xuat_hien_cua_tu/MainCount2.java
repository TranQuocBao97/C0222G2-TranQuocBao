package ss11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_tu;

import java.util.TreeMap;

public class MainCount2 {
    public static void main(String[] args) {
        String string = "day la mot van ban test dung de test";
        String[] arrString = string.split("");


        TreeMap<String, Integer> map = new TreeMap<>();
        map.put(arrString[0], 1);
        for (int i = 1; i < arrString.length; i++) {
            for(String key : map.keySet()){
                if(!(key.equals(arrString[i]))){
                    map.put(arrString[i], 1);
                }else{
                    map.put(arrString[i],(map.get(key)+1));
                }
            }
        }

        System.out.println(map);
    }
}
