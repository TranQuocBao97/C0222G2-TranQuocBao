package ss23_behavior_design_pattern.observer;

public class Main {
    public static void main(String[] args) {
        HotGirt hotGirt = new HotGirt();
        hotGirt.add(new Boy("boy1"));
        hotGirt.add(new Boy("boy2"));
        hotGirt.add(new Boy("boy3"));
        hotGirt.postFaceBook();
    }
}
