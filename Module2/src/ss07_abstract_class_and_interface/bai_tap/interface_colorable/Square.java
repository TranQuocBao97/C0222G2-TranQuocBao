package ss07_abstract_class_and_interface.bai_tap.interface_colorable;

import ss07_abstract_class_and_interface.bai_tap.interface_resizeable.Shape;

public class Square extends Shape implements Colorable {
    private double edge = 1.0;

    public Square(double edge) {
        this.edge = edge;
    }

    public Square(String color, boolean filled, double edge) {
        super(color, filled);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }
    public double getArea(){
        return edge*edge;
    }

    public void howToColor() {
        System.out.println("Color for all sides");
    }
}
