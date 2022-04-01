package test;

import java.util.Scanner;

public class UngDungDocSoThanhChu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc (0-999): ");
        String number = scanner.nextLine();
        while (!(number.matches("[1-9][0-9][0-9]")|| (number.matches("[1-9][0-9]")) || (number.matches("[0-9]")))){
            System.out.print("Nhập số cần đọc (0-999): ");
            number = scanner.nextLine();
        }
        String[] numberArray = number.split("");
        switch (numberArray.length){
            case 0:
                if(numberArray[0].equals("0")){
                    System.out.println("Zero");
                }else {
                    System.out.println(under10(numberArray[0]));
                }
        }
    }

    private static String under10(String number) {
        switch (number){
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            default:
                return "out of number";
        }

    }
}
