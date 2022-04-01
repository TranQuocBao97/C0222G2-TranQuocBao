package ss01_introduction_to_Java.bai_tap;

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
            case 1:
                if(numberArray[0].equals("0")){
                    System.out.println("Zero");
                    break;
                }else {
                    System.out.println(under10(numberArray[0]));
                }
                break;
            case 2:
                System.out.println(under100(numberArray[0],numberArray[1]));
                break;
            case 3:
                System.out.println(under1000(numberArray[0],numberArray[1],numberArray[2]));
                break;
        }
    }

    private static String under1000(String number1, String number2, String number3) {
        return under10(number1)+" hundred "+ under100(number2,number3);
    }

    private static String under100(String number2, String number3) {
        switch (number2){
            case "1":
                switch (number3){
                    case "0":
                        return "Ten";
                    case "1":
                        return "Eleven";
                    case "2":
                        return "twelve";
                    case "3":
                        return "thirteen";
                    case "4":
                        return "fourteen";
                    case "5":
                        return "fifteen";
                    default:
                        return under10(number3)+"teen";
                }
            case "2":
                if ("0".equals(number3)) {
                    return "twenty";
                }
                return "twenty " + under10(number3);
            case "3":
                if ("0".equals(number3)) {
                    return "thirty";
                }
                return "thirty " + under10(number3);
            case "4":
                if ("0".equals(number3)) {
                    return "Forty";
                }
                return "Forty " + under10(number3);
            case "5":
                if ("0".equals(number3)) {
                    return "Fifty";
                }
                return "Fifty " + under10(number3);
            case "6":
                if ("0".equals(number3)) {
                    return "Sixty";
                }
                return "Sixty " + under10(number3);
            case "7":
                if ("0".equals(number3)) {
                    return "Seventy";
                }
                return "Seventy " + under10(number3);
            case "8":
                if ("0".equals(number3)) {
                    return "Eighty";
                }
                return "Eighty " + under10(number3);
            case "9":
                if ("0".equals(number3)) {
                    return "Ninety";
                }
                return "Ninety " + under10(number3);
        }
        return "";
    }


    private static String under10(String number3) {
        switch (number3){
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
