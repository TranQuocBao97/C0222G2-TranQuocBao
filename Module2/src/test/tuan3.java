package test;

public class tuan3 {
    public static void main(String[] args) {
        int n = 10;
        int m = n;
        int k=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= m-((i-1)*2); j++) {
                System.out.print(" * ");
            }
            System.out.println("");
            if(i>=n/2){
                for (int j = 0; j < (n-k)/2; j++) {
                    System.out.print("   ");
                }
                k=k+2;
                for (int j = 0; j < k; j++) {
                    System.out.print(" * ");
                }
            }
        }
    }
}
