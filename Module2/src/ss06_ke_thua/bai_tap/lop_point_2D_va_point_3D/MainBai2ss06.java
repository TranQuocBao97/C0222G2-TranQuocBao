package ss06_ke_thua.bai_tap.lop_point_2D_va_point_3D;

import ss06_ke_thua.bai_tap.lop_point_2D_va_point_3D.subClass_point2D.Point3D;

public class MainBai2ss06 {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(10.0f,20.0f);
        System.out.println(point2D);
        point2D.setXY(3.4f,2.5f);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(5.2f,6.5f,8.3f);
        System.out.println(point3D);
    }
}
