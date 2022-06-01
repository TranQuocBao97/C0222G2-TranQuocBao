//package test.test_day_comparator;
//
//import case_study_2.utils.current_time.CurrentTime;
//
//import java.util.*;
//
//public class TestMainDate {
//    public static void main(String[] args) {
//        List<DateTest> dateCompareList = new ArrayList<DateTest>();
//        DateTestComparator dateTestComparator = new DateTestComparator();
//        String dateString1 = "12/02/2001";
//        String dateString2 = "23/05/2022";
//        String[] dateArray1 = dateString1.split("/");
//        String[] dateArray2 = dateString2.split("/");
//        dateCompareList.add(new DateTest(Integer.parseInt(dateArray1[0]), Integer.parseInt(dateArray1[1]), Integer.parseInt(dateArray1[2])));
//        dateCompareList.add(new DateTest(Integer.parseInt(dateArray2[0]), Integer.parseInt(dateArray2[1]), Integer.parseInt(dateArray2[2])));
//        dateCompareList.add(new DateTest(11, 6, 2010));
//        dateCompareList.sort(dateTestComparator);
//        for (DateTest dateTest : dateCompareList) {
//            System.out.println(dateTest);
//        }
//        boolean confirm18 = false;
//        confirm18 = checkOver18AndUnder100(dateString1);
//        System.out.println("confirm18: " + confirm18);
//    }
//
//    private static boolean checkOver18AndUnder100(String birthTime) {
//        String currentTime = CurrentTime.getCurrentTime();
//        System.out.println("Ngày sinh truyền vào : " + birthTime);
//        System.out.println("Thời Gian hiện tại : " + currentTime);
//        String[] birth = birthTime.split("/");
//        Integer birthDate = Integer.parseInt(birth[0]);
//        Integer birthMonth = Integer.parseInt(birth[1]);
//        Integer birthYear = Integer.parseInt(birth[2]);
//        String[] current = currentTime.split("/");
//        Integer currentDate = Integer.parseInt(current[0]);
//        Integer currentMonth = Integer.parseInt(current[1]);
//        Integer currentYear = Integer.parseInt(current[2]);
//        if (currentYear - birthYear > 100 || currentYear-birthYear <18) {
//            return false;
//        }
//        if (currentYear - birthYear > 18 && currentYear - birthYear < 100) {
//            return true;
//        }
//        if (currentYear - birthYear == 100)
//            if(currentMonth > birthMonth) {
//            return false;
//            } else if(currentMonth < birthMonth){
//                return true;
//            } else {
//                return currentDate <= birthDate;
//            }
//
//        if (currentMonth > birthMonth) {
//            return true;
//        } else if (currentMonth < birthMonth) {
//            return false;
//        } else {
//            return currentDate >= birthDate;
//        }
//    }
//
//}
