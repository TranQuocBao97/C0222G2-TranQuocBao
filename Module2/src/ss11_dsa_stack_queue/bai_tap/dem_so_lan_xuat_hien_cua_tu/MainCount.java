package ss11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_tu;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.TreeMap;

public class MainCount {
    public static void main(String[] args) {
        String string = "day la mot van ban test dung de test";
        String[] arrString = string.split("");


        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> keyMap = new TreeMap<>();

        for (int i = 0; i < arrString.length; i++) {
            keyMap.put(arrString[i], 1);
        }
        for (String v : keyMap.keySet()) {
            int value = 0;
            for (int i = 0; i < arrString.length; i++) {
                if (v.equals(arrString[i])) {
                    value++;
                }
            }
            map.put(v, value);
        }
        System.out.println(map);

    }
}
