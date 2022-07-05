package ss23_behavior_design_pattern.strategy;

import java.util.List;

public class InsertSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println(" InsertSort");
    }
}
