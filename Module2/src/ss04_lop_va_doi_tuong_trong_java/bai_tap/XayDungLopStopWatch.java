package ss04_lop_va_doi_tuong_trong_java.bai_tap;


import java.util.Scanner;

public class XayDungLopStopWatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập độ dài của mảng : ");
        int number = input.nextInt();
        int[] arrayNumber = new int[number];
//        System.out.print("Mảng gốc random : ");
//        for (int i = 0; i < number; i++) {
//            arrayNumber[i]= (int)(Math.random()*100);
//            System.out.print(arrayNumber[i]+" ");
//        }


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selectionSort(arrayNumber);
        stopWatch.stop();
        System.out.print("The time to do (millisecond) = " + stopWatch.getElapsedTime());
//        System.out.print("\nMảng sắp xếp từ bé đến lớn: ");
//        for(int a: arrayNumber){
//            System.out.print(a+" ");
//        }


    }

    private static void selectionSort(int[] arrayNumber) {
        int location = 0;
        for (int i = 0; i < arrayNumber.length; i++) {
            int min = arrayNumber[i];
            for (int j = i + 1; j < arrayNumber.length; j++) {
                if (min > arrayNumber[j]) {
                    min = arrayNumber[j];
                    location = j;
                }
            }
            arrayNumber[location] = arrayNumber[i];
            arrayNumber[i] = min;
        }
    }


    public static class StopWatch {
        long startTime;
        long endTime;

        public void start() {
            this.startTime = System.currentTimeMillis();
        }

        public void stop() {
            this.endTime = System.currentTimeMillis();
        }

        public long getElapsedTime() {
            return endTime - startTime;
        }

    }
}
