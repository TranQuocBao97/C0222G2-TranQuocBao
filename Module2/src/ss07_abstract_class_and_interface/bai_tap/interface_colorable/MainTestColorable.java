package ss07_abstract_class_and_interface.bai_tap.interface_colorable;

import ss07_abstract_class_and_interface.bai_tap.interface_resizeable.Circle;
import ss07_abstract_class_and_interface.bai_tap.interface_resizeable.Rectangle;
import ss07_abstract_class_and_interface.bai_tap.interface_resizeable.Shape;

public class MainTestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(5.0, 6.0);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            if(shape instanceof Circle){
                System.out.println("Area of the Circle : "+((Circle) shape).getArea());
            }
            if(shape instanceof Rectangle){
                System.out.println("Area of the Rectangle : "+((Rectangle) shape).getArea());
            }
            if (shape instanceof Square){
                System.out.println("Area of the Square: "+((Square) shape).getArea());
                ((Square) shape).howToColor();
            }
        }


    }
}
