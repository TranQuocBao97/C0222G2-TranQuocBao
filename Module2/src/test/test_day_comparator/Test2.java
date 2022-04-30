package test.test_day_comparator;

import case_study_2.utils.compareTime.DateString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dayStart1 = "03/05/2022";
        String dayEnd1 = "07/05/2022";
        String dayStart2 = "02/05/2022";
        String dayEnd2 = "07/04/2022";
        Date dateStart1 = null;
        Date dateEnd1 = null;
        Date dateStart2 = null;
        Date dateEnd2 = null;

        try {
            dateStart2 = simpleDateFormat.parse(dayStart2);
            dateEnd2 = simpleDateFormat.parse(dayEnd2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateStart2.getTime());
        System.out.println(dateEnd2.getTime());
        System.out.println(dateEnd2.getTime()-dateStart2.getTime());
        Integer numberOfDay = Math.toIntExact(dateStart2.getTime() / (1000 * 60 * 60 * 24));
        Integer number2 = Integer.parseInt(String.valueOf(dateStart2.getTime() / (1000 * 60 * 60 * 24)));
        System.out.println(numberOfDay);
        System.out.println(number2);
        Integer number3 = DateString.swapToIntegerDay(dayStart1);
        System.out.println(number3);
        System.out.println(DateString.checkIsADate("1"));


    }
}

//            try {
//                dateStart1 = simpleDateFormat.parse(dayStart1);
//                dateEnd1 = simpleDateFormat.parse(dayEnd1);
//                dateStart2 = simpleDateFormat.parse(dayStart2);
//                dateEnd2 = simpleDateFormat.parse(dayEnd2);
//                if(dateStart2.getTime()>=dateStart1.getTime()){
//                    if(dateStart2.getTime()<dateEnd1.getTime()){
//                        System.out.println(dateEnd2.getTime());
//                        System.out.println("trả về true");
//                    }else {
//                        System.out.println("Trả về false");
//                    }
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//
//        }
//    }
//}
