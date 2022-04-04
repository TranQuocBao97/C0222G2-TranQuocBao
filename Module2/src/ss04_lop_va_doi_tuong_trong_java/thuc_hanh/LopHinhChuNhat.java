package ss04_lop_va_doi_tuong_trong_java.thuc_hanh;

import java.util.Scanner;

public class LopHinhChuNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n"+rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+rectangle.getArea());


    }

    public static class Rectangle {
        double width;
        double height;

        public Rectangle() {
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return (this.width + this.height) * 2;
        }

        public String display() {
            return "Rectangle{" + "width=" + width + ", height=" + height + "}";
        }
    }
}
