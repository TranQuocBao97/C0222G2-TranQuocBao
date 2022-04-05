package ss04_lop_va_doi_tuong_trong_java.bai_tap.XayDungFan;

import ss04_lop_va_doi_tuong_trong_java.bai_tap.Fan2;

public class XayDungFan2 {
    public static void main(String[] args) {
        Fan2 fan1 = new Fan2();
        fan1.setSpeed(Fan2.Fast);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);

        System.out.println(fan1);

        Fan2 fan2 = new Fan2();
        fan2.setSpeed(Fan2.Medium);
        fan2.setRadius(5);
        fan2.setColor("White");
        fan2.setStatus(false);

        System.out.println(fan2);

        Fan2 fan3 = new Fan2();
        fan3.setSpeed(Fan2.Slow);
        fan3.setRadius(7);
        fan3.setColor("red");
        fan3.setStatus(true);

        System.out.println(fan3);
    }
}
