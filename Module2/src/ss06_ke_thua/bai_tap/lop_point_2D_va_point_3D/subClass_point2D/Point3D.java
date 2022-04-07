package ss06_ke_thua.bai_tap.lop_point_2D_va_point_3D.subClass_point2D;

import ss06_ke_thua.bai_tap.lop_point_2D_va_point_3D.Point2D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }
    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z){
        this.setX(x);
        this.setY(y);
        this.z = z;
    }
    public float[] getXYZ(){
        return new float[] {this.getX(),this.getY(),z};
    }

    @Override
    public String toString() {
        return "Point3D (x,y,z) = "
                +"("+this.getX()+","+this.getY()+","+z+")";
    }
}
