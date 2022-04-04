package ss03.bai_tap;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int[] array = {4, 5, 3, 6, 7, 7, 5, 9, 4, 1};

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.print("min value in this array is : " + min);
    }
}
