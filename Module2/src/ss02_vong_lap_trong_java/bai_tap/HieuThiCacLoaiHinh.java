package ss02_vong_lap_trong_java.bai_tap;

import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class HieuThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    int edge1 = -1;
                    int edge2 = -1;
                    while (edge1 <= 0 || edge2 <= 0) {
                        System.out.println("edge1 : ");
                        edge1 = input.nextInt();
                        System.out.println("edge2 : ");
                        edge2 = input.nextInt();
                        if (edge1 > 0 && edge2 > 0) {
                            for (int i = 0; i < edge1; i++) {
                                for (int j = 0; j < edge2; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("\n");
                            }
                        }
                    }
                    break;
                case 2:
                    int height = -1;
                    while (height <= 0) {
                        System.out.println("height : ");
                        height = input.nextInt();
                        if (height > 0) {
                            for (int i = 0; i <= height; i++) {
                                for (int j = 0; j < i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println("\n");
                            }
                            for (int i = 0; i <= height; i++) {
                                for (int j = height; j > i; j--) {
                                    System.out.print("* ");
                                }
                                System.out.println("\n");
                            }
                        }
                    }
                    break;
                case 3:
                    int height3 = -1;
                    while (height3 <= 0) {
                        System.out.println("height3 : ");
                        height3 = input.nextInt();
                        if (height3 > 0) {
                            int d = height3;
                            int u = height3;
                            for (int i = 1; i <= height3; i++) {
                                for (int j = 1; j <= u; j++) {
                                    if (j >= d && j <= u) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.print("\n");
                                d--;
                                u++;
                            }
                        }
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("choice the number in program!");

            }
        }
    }
}
