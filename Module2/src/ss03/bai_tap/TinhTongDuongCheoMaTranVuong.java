package ss03.bai_tap;

import java.util.Scanner;

public class TinhTongDuongCheoMaTranVuong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your edge of matrix square: ");
        int edgeOfSquare = input.nextInt();

        int[][] squareMatrix = new int[edgeOfSquare][edgeOfSquare];
        int sum = 0;

        System.out.print("Your square matrix: \n");
        for (int i = 0; i < edgeOfSquare; i++) {
            for (int j = 0; j < edgeOfSquare; j++) {
                squareMatrix[i][j] = (int) (Math.random() * 100);
                System.out.print(squareMatrix[i][j] + " ");
                if (i == j) {
                    sum += squareMatrix[i][j];
                }
            }
            System.out.print("\n");
        }

        System.out.print("Sum for diagonal line of your square matrix: " + sum);

    }
}
