package ss23_behavior_design_pattern.strategy;

import java.util.List;

public interface SortStrategy {

	<T> void sort(List<T> items);
}
