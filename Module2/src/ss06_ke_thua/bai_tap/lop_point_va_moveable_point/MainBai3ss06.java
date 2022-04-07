package ss06_ke_thua.bai_tap.lop_point_va_moveable_point;

import ss06_ke_thua.bai_tap.lop_point_va_moveable_point.point_subclasses.MovablePoint;

public class MainBai3ss06 {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(5.3f,3.5f);
        System.out.println(point);


        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);
        movablePoint = new MovablePoint(4.2f,5.3f);
        movablePoint.setXY(10.4f,9f);
        System.out.println(movablePoint);

    }
}
