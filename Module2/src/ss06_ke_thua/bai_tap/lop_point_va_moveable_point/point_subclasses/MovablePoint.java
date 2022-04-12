package ss06_ke_thua.bai_tap.lop_point_va_moveable_point.point_subclasses;

import ss06_ke_thua.bai_tap.lop_point_va_moveable_point.Point;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }

    @Override
    public String toString() {
        return "MovePoint (x,y) = ("+this.getX()+","+this.getY()+")"
                + ". Speed = ("+this.getXSpeed()+","+this.getYSpeed()+")";
    }

    public float[] movablePoint(){
        this.setXY(this.getX()+this.xSpeed,this.getY()+this.ySpeed);
        return this.getXY();
    }
}