package ss23_behavior_design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class HotGirt implements Subject{

  public List<Boy> friendZone = new ArrayList<>();

    public HotGirt() {
    }
    @Override
    public void add(Observer observer) {
        friendZone.add((Boy)observer);
    }

    @Override
    public void remove(Observer observer) {
        // code remove
    }

    @Override
    public void note(){
        for (Boy boy: friendZone){
            boy.care();
        }
    }
    public void postFaceBook(){
        System.out.println("post succesfully");
        note();
    }

}
