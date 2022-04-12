package ss06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import ss06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle.shape_subClasses.Triangle;

public class MainBai4ss06 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        try {
            triangle = new Triangle(1,1,2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(triangle);

        try {
            triangle = new Triangle(3,4,5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(triangle);
        try{
            triangle = new Triangle("red",3,4,5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(triangle);
        System.out.println("Perimeter: "+triangle.getPerimeter());
        System.out.println("Area: "+triangle.getArea(triangle.getPerimeter()));

    }
}
