package ss16_iO_text_file.bai_tap.doc_file_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main01Ss16 {
    private static final String FILE_COUNTRY = "src/ss16_iO_text_file/bai_tap/doc_file_csv/CountrySs16.csv";
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader bufferedReader = null;

        try {
            String line;
            FileReader fileReader = new FileReader(FILE_COUNTRY);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine())!=null){
                printCountry(splitLineCsvData(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static List<String> splitLineCsvData(String lineInCsvData){
        List<String> propertiesList = new ArrayList<>();
        if(lineInCsvData!= null){
            String[] splitData = lineInCsvData.split(",");
            for (int i = 0; i < splitData.length; i++) {
                propertiesList.add(splitData[i]);
            }
        }
        return propertiesList;
    }
    private static void printCountry(List<String> country) {
        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]");
    }
}
