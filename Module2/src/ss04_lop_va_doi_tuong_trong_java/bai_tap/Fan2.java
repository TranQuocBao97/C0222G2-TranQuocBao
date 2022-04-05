package ss04_lop_va_doi_tuong_trong_java.bai_tap;

public class Fan2 {
    boolean status = false;
    public static final int Slow = 1;
    public static final int Medium = 2;
    public static final int Fast = 3;
    int speed = 1;
    double radius = 5;
    String color = "blue";


    public Fan2() {
    }

    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public void setSpeed(int newValue) {
        if (newValue >= 1 && newValue <= 3) {
            speed = newValue;
        }
    }

    @Override
    public String toString() {
        if (this.status) {
            return "Fan{" +
                    "Fan is on" +
                    ", speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan{" +
                    "Fan is off" +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
