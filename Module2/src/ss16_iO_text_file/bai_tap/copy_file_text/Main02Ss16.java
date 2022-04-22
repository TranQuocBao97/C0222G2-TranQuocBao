package ss16_iO_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main02Ss16 {
    private static final String FILE_ORIGINAL = "src/ss16_iO_text_file/bai_tap/copy_file_text/originalFileSs16.txt";
    private static final String FILE_COPY = "src/ss16_iO_text_file/bai_tap/copy_file_text/copyFileSs16.txt";

    public static void main(String[] args) {
        writeFile(readFile(FILE_ORIGINAL),FILE_COPY);
    }

    public static List<String> readFile(String originFile) {
        List<String> originDataList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(originFile));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                originDataList.add(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File not found or file have nothing");
            ;
        }
        return originDataList;
    }

    public static void writeFile(List<String> dataList, String copyFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(copyFile, false));
            for (String string : dataList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
