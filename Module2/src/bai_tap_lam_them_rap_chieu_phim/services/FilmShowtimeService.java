package bai_tap_lam_them_rap_chieu_phim.services;

import bai_tap_lam_them_rap_chieu_phim.models.Film;
import bai_tap_lam_them_rap_chieu_phim.models.FilmShowtime;
import bai_tap_lam_them_rap_chieu_phim.utils.get_data_input.IntegerInput;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.ReadFile;
import bai_tap_lam_them_rap_chieu_phim.utils.regex.RegexShowtimeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmShowtimeService {
    private static final String FILE_DATA_FILM  = "src/bai_tap_lam_them_rap_chieu_phim/data/file_data_film.csv";
    private static final String FILE_DATA_FILM_SHOWTIME = "src/bai_tap_lam_them_rap_chieu_phim/data/file_data_filmShowTime.csv";
    static Scanner scanner = new Scanner(System.in);
    private static final List<FilmShowtime> listFilmShowTime  = new ArrayList<>();

    public void displayAllFilmShowtime(){

    }

    public void addFilmShowtime(){
        String filmInformation = selectFilm();


        String code;
        do{
            System.out.print("Enter filmShowtime code (CI-XXXX, X is a number): ");
            code = scanner.nextLine();
        }while (!RegexShowtimeCode.checkFilmShowtimeCode(code));


    }

    private String selectFilm() {
        List<Film> filmList = ReadFile.readFileFilmData(FILE_DATA_FILM);
        int stt = 0;
        for (Film film : filmList){
            System.out.println("STT."+(++stt)+": "+film);
        }
        Integer select = IntegerInput.getIntegerInput();
        for (int i = 0; i < filmList.size(); i++) {
            if(select == i+1){
                return filmList.get(i).toString();
            }
        }
    }

}
