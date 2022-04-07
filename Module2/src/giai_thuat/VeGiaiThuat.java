package giai_thuat;

public class VeGiaiThuat {
    public static void main(String[] args) {
        int n =5;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n*2; j++) {
                if(j==n){
                    System.out.print(" ");
                }else if(j==n+i || j==n-i){
                    System.out.print(i);
                }else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n*2; j++) {
                if(j==i ||j==n*2-i){
                    System.out.print(n-i);
                }else  {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
