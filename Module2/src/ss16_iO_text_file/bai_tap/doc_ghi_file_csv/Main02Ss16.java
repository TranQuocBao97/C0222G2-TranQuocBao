package ss16_iO_text_file.bai_tap.doc_ghi_file_csv;

import java.util.ArrayList;
import java.util.List;

public class Main02Ss16 {
    private static final String FILE_FOR_READ = "src/ss16_iO_text_file/bai_tap/doc_ghi_file_csv/Country02Ss16.csv";
    private static final String FILE_TAKE_DATA = "src/ss16_iO_text_file/bai_tap/doc_ghi_file_csv/File_TakeData.csv";
    public static void main(String[] args) {
        ReadAndWriteFile02Ss16 readAndWrite = new ReadAndWriteFile02Ss16();
        List<Country02Ss16> countryList = readAndWrite.countryListFormFile(FILE_FOR_READ);
        for (Country02Ss16 country:countryList){
            System.out.println(country);
        }
        readAndWrite.writeCountryListToCsvFile(FILE_TAKE_DATA,countryList,false);
    }
}
