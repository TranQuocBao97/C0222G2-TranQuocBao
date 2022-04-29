package test.test_day_comparator;

import java.util.Comparator;

public class DateTestComparator implements Comparator<DateTest> {

    @Override
    public int compare(DateTest o1, DateTest o2) {
        if(!o1.getYear().equals(o2.getYear())){
            return o1.getYear()-o2.getYear();
        }else if(!o1.getMonth().equals(o2.getMonth())){
            return o1.getMonth()-o2.getMonth();
        }else if(!o1.getDay().equals(o2.getDay())){
            return o1.getDay()-o2.getDay();
        }
        return 0;
    }
}
