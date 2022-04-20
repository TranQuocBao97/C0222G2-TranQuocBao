package ss14_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class MoTaSapXepChen {
    public static void main(String[] args) {
        int array[] = {2,4,6,3,2,4,7,8,3,5};
        insertionSort(array);
    }
    public static void insertionSort(int[] array){
        int index;
        int min;
        for(int i = 1; i < array.length; i++){ 
            min = array[i];
            index = i;
            while(index > 0 && min < array[index-1]){
                array[index] = array[index-1];
                index--;
            }
            array[index] = min;
        }
        System.out.println(Arrays.toString(array));

    }
}
