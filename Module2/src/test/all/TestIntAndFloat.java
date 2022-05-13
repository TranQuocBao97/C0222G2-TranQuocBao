package test.all;

public class TestIntAndFloat {
    public static void main(String[] args) {
        int n1 = 5;
        float n2 = (float) (Math.pow(2,64)-65);
        System.out.println(n2);
        n1 = (int) n2;
        System.out.println(n1);
    }
}
