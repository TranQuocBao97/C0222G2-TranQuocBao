package ss23_behavior_design_pattern.observer;

public interface Subject {
    void add(Observer observer);
    void remove(Observer observer);
    void note();
}
