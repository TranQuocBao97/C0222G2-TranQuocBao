package ss07_abstract_class_and_interface.thuc_hanh.lop_animal_va_interface_edible;

public class Apple extends Fruit{
    @Override
    public String howToEat() {
        return "Apple could be slided";
    }

    @Override
    public String timeToRot() {
        return "four days will be rot";
    }
}
