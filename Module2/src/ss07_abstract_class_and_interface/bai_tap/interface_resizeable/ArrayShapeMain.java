package ss07_abstract_class_and_interface.bai_tap.interface_resizeable;

public class ArrayShapeMain {
    public static void main(String[] args) {
        int random = (int) (Math.random() * 100);
        System.out.println("random percent: "+random+"%");
        Shape[] shapes = new Shape[2];


        shapes[0]= new Circle(5.0);
//        Circle circle1 = (Circle) shapes[0];
//        System.out.println(circle1.getArea());
//        circle1.resize(random);
//        System.out.println(circle1.getArea());


        shapes[1]= new Rectangle(5.0,6.0);
//        Rectangle rectangle1 = (Rectangle) shapes[1];
//        System.out.println(rectangle1.getArea());
//        rectangle1.resize(random);
//        System.out.println(rectangle1.getArea());


        for(Shape shape : shapes){
            if(shape instanceof Circle){
                System.out.println("The circle's area : "+((Circle) shape).getArea());
                ((Circle) shape).resize(random);
                System.out.println("The circle's area after resize: "+ ((Circle) shape).getArea());
            }
            if(shape instanceof Rectangle){
                System.out.println("The rectangle's area : " + ((Rectangle) shape).getArea());
                ((Rectangle) shape).resize(random);
                System.out.println("The rectangle's area after resize : "+ ((Rectangle) shape).getArea());
            }
        }
    }
}
