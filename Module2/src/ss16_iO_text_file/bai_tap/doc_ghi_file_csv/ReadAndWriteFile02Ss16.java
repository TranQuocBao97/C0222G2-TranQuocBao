package ss16_iO_text_file.bai_tap.doc_ghi_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile02Ss16 {

    public List<String> readFile(String file_ForRead){
        List<String> dataListFromFile = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file_ForRead));
            String line ="";
            while((line = bufferedReader.readLine())!=null){
                dataListFromFile.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataListFromFile;
    }

    public List<Country02Ss16> countryListFormFile (String file_ForRead){
        List<String> listString = readFile(file_ForRead);
        List<Country02Ss16> listCountry = new ArrayList<>();

        for(String string : listString){
            String[] properties = string.split(",");
            listCountry.add(new Country02Ss16(Integer.parseInt(properties[0]),properties[1],properties[2]));
        }
        return listCountry;
    }

    public void writeToCsvFile(String fileTakeWrite, List<String> dataList, boolean flag){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTakeWrite,flag));
            for(String line : dataList){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeCountryListToCsvFile(String fileTakeWrite, List<Country02Ss16> countryList, boolean flag){
        List<String> dataList = new ArrayList<>();
        for(Country02Ss16 country : countryList){
            dataList.add(country.eachPropertiesToCsv());
        }
        writeToCsvFile(fileTakeWrite,dataList,flag);
    }
}

