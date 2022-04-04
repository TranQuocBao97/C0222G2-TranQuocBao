package ss03.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKiTuTrongChuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your paragraph: ");
        String str = input.nextLine();

        System.out.print("Enter your word you want to count the time it's show up : ");
        String oneWord;
        do {
            oneWord = input.nextLine();
            if (oneWord.length() != 1) {
                System.out.println("Please enter 1 word!!!");
            }
        } while (oneWord.length() != 1);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == oneWord.charAt(0)) {
                count++;
            }
        }
        System.out.print("The time this word (" + oneWord + ") appear in the paragraph is: " + count);

    }

}
