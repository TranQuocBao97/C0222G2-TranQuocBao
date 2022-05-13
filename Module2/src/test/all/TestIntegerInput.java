package test.all;

import java.util.Scanner;

public class TestIntegerInput {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Integer test = Integer.parseInt(scanner.nextLine());
        System.out.println(test);
    }
}
