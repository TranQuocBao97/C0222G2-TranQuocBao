package ss04_lop_va_doi_tuong_trong_java.bai_tap;

public class XayDungLopFan {
    public static void main(String[] args) {

    }

    public static class Fan {
        boolean on = false;
        int slow = 1;
        int medium = 2;
        int fast = 3;
        int speed = 1;
        String color = "blue";



        public Fan(){
        }

        private void turnOn(){
             on = true;
        }
        private void turnOff(){
             on = false;
        }

        private void setSpeed(int newValue){
            switch (speed){
                case 1:
                    speed = slow;
                case 2:
                    speed = medium;
                case 3:
                    speed = fast;
            }
        }

    }
}
