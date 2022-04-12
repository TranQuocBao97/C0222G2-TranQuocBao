package ss07_abstract_class_and_interface.thuc_hanh.lop_animal_va_interface_edible;

public class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Chicken: Tok-Tok!!!";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
