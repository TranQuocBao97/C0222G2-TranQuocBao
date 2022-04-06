package ss05.thuc_hanh.static_property;

public class TestCar {
    public static void main(String[] args) {
        Car car1 = new Car("Lambo","v10");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Honda 5", "V6");
        System.out.println(Car.numberOfCars);
        Car car3 = new Car("Suzuki 4", "v8");
        System.out.println(Car.numberOfCars);
    }
}
