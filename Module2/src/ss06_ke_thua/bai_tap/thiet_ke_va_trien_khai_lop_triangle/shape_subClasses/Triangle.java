package ss06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle.shape_subClasses;

import ss06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle.Shape;

public class Triangle extends Shape {

    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;


    public Triangle() {
        System.out.println("This is basic triangle");
    }


    public Triangle(double side1, double side2, double side3) throws Exception {
        if(side1>0 && side2>0 && side3>0 && side1+side2>side3 && side2+side3>side1 && side1+side3>side2){
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
        } else {
            throw new Exception("three sides is not able to make the triangle");
        }

    }

    public Triangle(String color, double side1, double side2, double side3) throws Exception {
        super(color);
        if(side1>0 && side2>0 && side3>0 && side1+side2>side3 && side2+side3>side1 && side1+side3>side2){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            throw new Exception("three sides is not able to make the triangle");
        }

    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter(){
        return side1+side2+side3;
    }
    public double getArea(double p){
        p = this.getPerimeter()/2;
        return Math.pow(p*(p-side1)*(p-side2)*(p-side3),0.5);
    }

    @Override
    public String toString() {
        return "Triangle : " +
                "side1= " + side1 +
                ", side2= " + side2 +
                ", side3= " + side3 +
                " | " + super.toString();
    }
}
