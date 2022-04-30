package case_study_2.utils.compareTime;

import case_study_2.utils.current_time.CurrentTime;

public class BookingTimeCompare {

    public static boolean checkTimeStartWithCurrent(String timeStart){
        String current = CurrentTime.getCurrentTime();
        String[] currentArray = current.split("/");
        int currentDate = Integer.parseInt(currentArray[0]);
        int currentMonth= Integer.parseInt(currentArray[1]);
        int currentYear = Integer.parseInt(currentArray[2]);

        String[] timeStartArray = timeStart.split("/");
        int startDate = Integer.parseInt(timeStartArray[0]);
        int startMonth = Integer.parseInt(timeStartArray[1]);
        int startYear = Integer.parseInt(timeStartArray[2]);
        if(startYear>currentYear){
            return true;
        } else if(startYear<currentYear){
            return false;
        }else if(startMonth>currentMonth){
            return true;
        }else if(startMonth<currentMonth){
            return false;
        }else return startDate >= currentDate;
    }

    public static boolean checkTimeEndWithStart(String timeStart,String timeEnd){
        String[] timeStartArray = timeStart.split("/");
        int startDate = Integer.parseInt(timeStartArray[0]);
        int startMonth = Integer.parseInt(timeStartArray[1]);
        int startYear = Integer.parseInt(timeStartArray[2]);

        String[] timeEndArray = timeEnd.split("/");
        int endDate = Integer.parseInt(timeEndArray[0]);
        int endMonth = Integer.parseInt(timeEndArray[1]);
        int endYear = Integer.parseInt(timeEndArray[2]);

        if(endYear>startYear){
            return true;
        } else if(endYear<startYear){
            return false;
        }else if(endMonth>startMonth){
            return true;
        }else if(endMonth<startMonth){
            return false;
        }else return endDate > startDate;

    }





}
