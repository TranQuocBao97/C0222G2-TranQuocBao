package ss03.bai_tap;

import java.util.Scanner;

public class TinhTongMotSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your row matrix : ");
        int row = input.nextInt();
        System.out.print("Enter your column matrix : ");
        int column = input.nextInt();
        System.out.println("Enter the column you want to Sum : ");
        int theColumnForSum = input.nextInt();

        int[][] matrix = new int[row][column];

        System.out.print("The matrix here : \n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += matrix[i][theColumnForSum];
        }
        System.out.print("Sum for all value of column " + theColumnForSum + ": " + sum);


    }
}
