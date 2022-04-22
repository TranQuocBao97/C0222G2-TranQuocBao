package ss16_iO_text_file.thuc_hanh.tim_gia_tri_lon_nhat;

import java.util.List;

public class MainSs16ThucHanh02 {
    public static void main(String[] args) {
        ReadAndWriteFileSs16 readAndWriteFileSs16 = new ReadAndWriteFileSs16();
        List<Integer> numbers = readAndWriteFileSs16.readFile("src/ss16_iO_text_file/thuc_hanh/tim_gia_tri_lon_nhat/thuchanhss16_number.csv");
        int maxValue = findMax(numbers);
        readAndWriteFileSs16.writeFile("src/ss16_iO_text_file/thuc_hanh/tim_gia_tri_lon_nhat/thuchanhss16_result.csv", maxValue);
    }
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
