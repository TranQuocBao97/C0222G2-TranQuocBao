public class hoa {
    public static void main(String[] args) {
        int fibo1 = 0;
        int fibo2 = 1;
        int fibo3 = 0;
        for (int i = 0; i < 100; i++) {
            if(i==fibo1+fibo2){
                fibo3 = i;
                fibo1=fibo2;
                fibo2=fibo3;
                System.out.println(fibo3);
            }
        }
    }
}
