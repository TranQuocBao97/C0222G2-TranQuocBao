package ss01_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhChiSoCanNangCuaCoThe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("your weight (in kilogram):");
        weight = scanner.nextDouble();

        System.out.print("your weight (in meter):");
        height = scanner.nextDouble();

        bmi = weight / Math.pow(height, 2);

        System.out.printf("%-50s%s", "bmi", "interpretation\n");

        if (bmi < 18)
            System.out.printf("%-50.6f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-50.6f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-50.6f%s", bmi, "Overweight");
        else
            System.out.printf("%-50.6f%s", bmi, "Obese");
    }
}
