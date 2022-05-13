package bai_thi.utils.read_and_write;

import bai_thi.models.sub_phone.HandPhone;
import bai_thi.models.sub_phone.RealPhone;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void writerListStringToCsv(String fileDataUrl, List<String> listData, boolean flag){
        try{
            FileWriter fileWriter = new FileWriter(fileDataUrl,flag);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String data : listData){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (FileNotFoundException e){
            System.out.println("The File is not found");
        }catch (IOException e){
            System.out.println("Cant write to the file");
        }catch (Exception e){
            System.out.println("something wrong");
        }
    }

    public static void writeListRealPhoneToCsv(String fileDataUrl, List<RealPhone> listRealPhone, boolean flag){
        List<String> listData = new ArrayList<>();
        for (RealPhone realPhone : listRealPhone){
            listData.add(realPhone.toStringCsv());
        }
        writerListStringToCsv(fileDataUrl,listData,flag);
    }

    public static void writeListHandPhoneToCsv(String fileDataUrl, List<HandPhone> listHandPhone, boolean flag){
        List<String> listData = new ArrayList<>();
        for (HandPhone handPhone : listHandPhone){
            listData.add(handPhone.toStringCsv());
        }
        writerListStringToCsv(fileDataUrl,listData,flag);
    }




}
