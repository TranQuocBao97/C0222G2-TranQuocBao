package ss05.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color ="red";
    private double area = radius*radius*Math.PI;

    Circle(){
    }

    Circle(double r){
        this.radius = r;
    }

    double getRadius() {
        return radius;
    }

    double getArea() {
        return area;
    }
}
