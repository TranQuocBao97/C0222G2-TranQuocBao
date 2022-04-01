package ss01_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số của bạn : ");
        int number = scanner.nextInt();

        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
        } else if (number < 20) {
            switch (number) {
                case 10:
                    System.out.println("Ten");
                    break;
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                default:
                    number = number - 10;
                    switch (number) {
                        case 3:
                            System.out.print("Third");
                            break;
                        case 4:
                            System.out.print("Four");
                            break;
                        case 5:
                            System.out.print("Fif");
                            break;
                        case 6:
                            System.out.print("Six");
                            break;
                        case 7:
                            System.out.print("Seven");
                            break;
                        case 8:
                            System.out.print("Eight");
                            break;
                        case 9:
                            System.out.print("Nine");
                            break;
                    }
                    System.out.print("teen");
            }
        } else if (number < 100) {
            int number1 = number / 10;
            switch (number1) {
                case 2:
                    System.out.print("Twenty");
                    break;
                case 3:
                    System.out.print("Thirty");
                    break;
                case 4:
                    System.out.print("Forty");
                    break;
                case 5:
                    System.out.print("Fifty");
                    break;
                case 6:
                    System.out.print("Sixty");
                    break;
                case 7:
                    System.out.print("Seventy");
                    break;
                case 8:
                    System.out.print("Eighty");
                    break;
                case 9:
                    System.out.print("Ninety");
                    break;
            }
            int number2 = number - number1 * 10;
            switch (number2) {
                case 0:
                    break;
                case 1:
                    System.out.print(" One");
                    break;
                case 2:
                    System.out.print(" Two");
                    break;
                case 3:
                    System.out.print(" Three");
                    break;
                case 4:
                    System.out.print(" Four");
                    break;
                case 5:
                    System.out.print(" Five");
                    break;
                case 6:
                    System.out.print(" Six");
                    break;
                case 7:
                    System.out.print(" Seven");
                    break;
                case 8:
                    System.out.print(" Eight");
                    break;
                case 9:
                    System.out.print(" Nine");
                    break;
            }
        } else if (number < 1000) {
            int number1 = number / 100;
            switch (number1) {
                case 1:
                    System.out.print("One hundred");
                    break;
                case 2:
                    System.out.print("Two hundred");
                    break;
                case 3:
                    System.out.print("Three hundred");
                    break;
                case 4:
                    System.out.print("Four hundred");
                    break;
                case 5:
                    System.out.print("Five hundred");
                    break;
                case 6:
                    System.out.print("Six hundred");
                    break;
                case 7:
                    System.out.print("Seven hundred");
                    break;
                case 8:
                    System.out.print("Eight hundred");
                    break;
                case 9:
                    System.out.print("Nine hundred");
                    break;
            }
            int number2 = number - (number1 * 100);
            int number3 = number2 / 10;
            switch (number3) {
                case 0:
                    int number4 = number2 - number3;
                    switch (number4) {
                        case 0:
                            break;
                        case 1:
                            System.out.print(" and one");
                            break;
                        case 2:
                            System.out.print(" abd two");
                            break;
                        case 3:
                            System.out.print(" and three");
                            break;
                        case 4:
                            System.out.print(" and four");
                            break;
                        case 5:
                            System.out.print(" and five");
                            break;
                        case 6:
                            System.out.print(" and six");
                            break;
                        case 7:
                            System.out.print(" and seven");
                            break;
                        case 8:
                            System.out.print(" and eight");
                            break;
                        case 9:
                            System.out.print(" and nine");
                            break;
                    }
                    return;
                case 2:
                    System.out.print(" and Twenty");
                    break;
                case 3:
                    System.out.print(" and Thirty");
                    break;
                case 4:
                    System.out.print(" and Forty");
                    break;
                case 5:
                    System.out.print(" and Fifty");
                    break;
                case 6:
                    System.out.print(" and Sixty");
                    break;
                case 7:
                    System.out.print(" and Seventy");
                    break;
                case 8:
                    System.out.print(" and Eighty");
                    break;
                case 9:
                    System.out.print(" and Ninety");
                    break;
                case 1:
                    switch (number2) {
                        case 10:
                            System.out.print(" and ten");
                            break;
                        case 11:
                            System.out.print(" and eleven");
                            break;
                        case 12:
                            System.out.print(" and twelve");
                            break;
                        case 13:
                            System.out.print(" and thirteen");
                            break;
                        case 14:
                            System.out.print(" and fourteen");
                            break;
                        case 15:
                            System.out.print(" and fifteen");
                            break;
                        case 16:
                            System.out.print(" and sixteen");
                            break;
                        case 17:
                            System.out.print(" and seventeen");
                            break;
                        case 18:
                            System.out.print(" and eighteen");
                            break;
                        case 19:
                            System.out.print(" and nineteen");
                            break;

                    }
                    return;

            }
            int number5 = number2 - number3*10;
            switch (number5) {
                case 0:
                    break;
                case 1:
                    System.out.print(" One");
                    break;
                case 2:
                    System.out.print(" Two");
                    break;
                case 3:
                    System.out.print(" Three");
                    break;
                case 4:
                    System.out.print(" Four");
                    break;
                case 5:
                    System.out.print(" Five");
                    break;
                case 6:
                    System.out.print(" Six");
                    break;
                case 7:
                    System.out.print(" Seven");
                    break;
                case 8:
                    System.out.print(" Eight");
                    break;
                case 9:
                    System.out.print(" Nine");
                    break;
            }
        }
        else {
            System.out.println("out of ability");
        }


    }
}
