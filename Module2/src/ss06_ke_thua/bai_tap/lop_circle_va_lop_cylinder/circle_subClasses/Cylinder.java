package ss06_ke_thua.bai_tap.lop_circle_va_lop_cylinder.circle_subClasses;

import ss06_ke_thua.bai_tap.lop_circle_va_lop_cylinder.Circle;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return this.getArea()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "} " +
                "subclasses "+ super.toString();
    }
}
