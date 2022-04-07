package ss06_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

import ss06_ke_thua.bai_tap.lop_circle_va_lop_cylinder.circle_subClasses.Cylinder;

public class MainBai1ss06 {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        Circle circle2 = new Circle(5.0,"red");
        System.out.println(circle2);
        System.out.println("Area of Circle2 = "+circle2.getArea());

        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);
        Cylinder cylinder2 = new Cylinder(5.0,"yellow",5.0);
        System.out.println(cylinder2);
        System.out.println("Volume of Cylinder2 = "+cylinder2.getVolume());
    }
}
