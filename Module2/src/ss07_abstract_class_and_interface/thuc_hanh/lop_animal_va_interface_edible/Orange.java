package ss07_abstract_class_and_interface.thuc_hanh.lop_animal_va_interface_edible;

public class Orange extends Fruit{
    @Override
    public String howToEat() {
        return "Orange could be juiced";
    }

    @Override
    public String timeToRot() {
        return "two days will be root";
    }
}
