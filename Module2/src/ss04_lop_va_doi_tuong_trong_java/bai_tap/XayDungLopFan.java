package ss04_lop_va_doi_tuong_trong_java.bai_tap;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class XayDungLopFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.Fast);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);

        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.Medium);
        fan2.setRadius(5);
        fan2.setColor("White");
        fan2.setStatus(false);

        System.out.println(fan2);

        Fan fan3 = new Fan();
        fan3.setSpeed(Fan.Slow);
        fan3.setRadius(7);
        fan3.setColor("red");
        fan3.setStatus(true);

        System.out.println(fan3);
    }

    public static class Fan {
        boolean status = false;
        private static final int Slow = 1;
        private static final int Medium = 2;
        private static final int Fast = 3;
        int speed = 1;
        double radius = 5;
        String color = "blue";


        public Fan(){
        }

        private void setStatus(boolean newStatus){
            this.status = newStatus;
        }
        private void setColor(String newColor){
            this.color = newColor;
        }
        private void setRadius(double newRadius){
            this.radius = newRadius;
        }

        private void setSpeed(int newValue){
            if(newValue>=1 && newValue<=3){
                speed = newValue;
            }
        }

        @Override
        public String toString() {
            if(this.status){
                return "Fan{" +
                        "Fan is on" +
                        ", speed=" + speed +
                        ", radius=" + radius +
                        ", color='" + color + '\'' +
                        '}';
            }else {
                return "Fan{" +
                        "Fan is off"+
                        ", radius=" + radius +
                        ", color='" + color + '\'' +
                        '}';
            }
        }
    }
}
