package ss03.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter the name you want to find : ");
        String inputName = input.nextLine();
        boolean confirm = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(inputName)) {
                System.out.println("Position of the students in the list " + inputName + " is: " + i);
                confirm = true;
                break;
            }
        }
        if (!confirm) {
            System.out.println("Not found" + inputName + " in the list.");
        }
    }
}
