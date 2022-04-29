package test.GiaiThuat1;

public class giaithuat {
    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=-1){
                int min = arr[i];
                for (int j = i+1; j < arr.length; j++) {
                    if(min>arr[j] && arr[j]!=-1){
                        min = arr[j];
                        arr[j]=arr[i];
                        arr[i]=min;
                    }
                }
            }
        }
        for (int a:arr) {
            System.out.println(a+" ");
        }

    }
}
