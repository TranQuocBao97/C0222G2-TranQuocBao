package bai_thi.utils.read_and_write;

import bai_thi.models.sub_phone.HandPhone;
import bai_thi.models.sub_phone.RealPhone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String fileDataUrl){
        List<String> listData = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(fileDataUrl);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                listData.add(line);
            }
            bufferedReader.close();
        } catch (Exception e){
            System.out.println("Some thing wrong");
        }
        return listData;
    }

//    public static List<RealPhone> readFileDataToRealPhoneList(String fileDataUrl){
//        List<RealPhone> realPhoneList = new ArrayList<>();
//        List<String> listData = readFile(fileDataUrl);
//        for (String dataStringLine : listData){
//            if (dataStringLine==null){
//                return null;
//            }
//            String[] dataArray = dataStringLine.split(",");
//
//            try{
//                realPhoneList.add(new RealPhone(Integer.parseInt(dataArray[0]),dataArray[1],Integer.parseInt(dataArray[2])
//                        ,Integer.parseInt(dataArray[3]),dataArray[4],Integer.parseInt(dataArray[5]),dataArray[6]));
//            }catch (Exception e){
//                System.out.println("?");
//            }
//
//        }
//        return realPhoneList;
//    }
    public static List<RealPhone> readFileDataToRealPhoneList(String fileDataUrl){
        List<RealPhone> realPhoneList = new ArrayList<>();
        List<String> listData = readFile(fileDataUrl);
        for (String dataStringLine : listData){
            String[] dataArray = dataStringLine.split(",");
            realPhoneList.add(new RealPhone(Integer.parseInt(dataArray[0]),dataArray[1],Integer.parseInt(dataArray[2])
                    ,Integer.parseInt(dataArray[3]),dataArray[4],Integer.parseInt(dataArray[5]),dataArray[6]));
        }
        return realPhoneList;
    }

//    public static List<HandPhone> readFileDataToHandPhoneList(String fileDataUrl){
//        List<HandPhone> handPhoneList = new ArrayList<>();
//        List<String> listData = readFile(fileDataUrl);
//        for (String dataStringLine : listData){
//            if (dataStringLine==null){
//                return null;
//            }
//            String[] dataArray = dataStringLine.split(",");
//            try{
//                handPhoneList.add(new HandPhone(Integer.parseInt(dataArray[0]),dataArray[1],Integer.parseInt(dataArray[2])
//                        ,Integer.parseInt(dataArray[3]),dataArray[4],dataArray[5],dataArray[6]));
//            }catch (Exception e){
//                System.out.println("?");
//            }
//
//        }
//        return handPhoneList;
//    }
public static List<HandPhone> readFileDataToHandPhoneList(String fileDataUrl){
    List<HandPhone> handPhoneList = new ArrayList<>();
    List<String> listData = readFile(fileDataUrl);
    for (String dataStringLine : listData){
        String[] dataArray = dataStringLine.split(",");
        handPhoneList.add(new HandPhone(Integer.parseInt(dataArray[0]),dataArray[1],Integer.parseInt(dataArray[2])
                       ,Integer.parseInt(dataArray[3]),dataArray[4],dataArray[5],dataArray[6]));
    }
    return handPhoneList;
}








}
