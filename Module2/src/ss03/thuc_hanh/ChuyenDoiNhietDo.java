package ss03.thuc_hanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;

        do {
            System.out.println("Pick Menu: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter fahrenheit: ");
                    fahrenheit = input.nextDouble();
                    System.out.print("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit) + "\n");
                    break;
                case 2:
                    System.out.print("Enter celsius ");
                    celsius = input.nextDouble();
                    System.out.print("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius) + "\n");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);

    }

    private static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}

