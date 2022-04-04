package ss03.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrayOne = {5, 7, 4, 4, 7, 8};
        int[] arrayTwo = {1, 1, 4, 4, 7, 8, 7, 4, 8, 1};

        int[] arrayThree = new int[arrayOne.length + arrayTwo.length];

        int i = 0;
        while (i != arrayOne.length) {
            arrayThree[i] = arrayOne[i];
            i++;
        }
        int j = 0;
        while (j != arrayTwo.length) {
            arrayThree[i] = arrayTwo[j];
            i++;
            j++;
        }

        System.out.print("new array: ");
        for (int a : arrayThree) {
            System.out.print(a + " ");
        }

    }
}
