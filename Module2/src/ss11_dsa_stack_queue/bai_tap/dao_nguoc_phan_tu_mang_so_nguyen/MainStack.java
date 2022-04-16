package ss11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        Stack<Integer> listStack = new Stack<>();
        for (int i = array.length-1; i >= 0; i--) {
            listStack.push(array[i]);
        }
        System.out.println(listStack);

        Stack<String> wStack = new Stack<>();
        String str = "Dat Nuoc Toi";
        String[] arrayWord = str.split("");
        System.out.println(Arrays.toString(arrayWord));
        for (int i = arrayWord.length-1; i >=0 ; i--) {
            wStack.push(arrayWord[i]);
        }
        System.out.println(wStack);


    }
}
