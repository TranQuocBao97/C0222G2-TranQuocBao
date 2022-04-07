package test.testOverride;


import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Animal tom = new Animal();
        tom.setName("Tom");
        tom.setAge(3);
        tom.setWeight(5);

        Animal jerry = new Animal();
        jerry.setName("Tom");
        jerry.setAge(3);
        jerry.setWeight(5);

        System.out.println(jerry.equals(tom));
        System.out.println(tom);
    }
}
