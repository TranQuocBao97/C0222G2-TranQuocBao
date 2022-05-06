package bai_tap_lam_them_rap_chieu_phim.services;

import bai_tap_lam_them_rap_chieu_phim.models.Film;
import bai_tap_lam_them_rap_chieu_phim.utils.get_data_input.IntegerInput;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.ReadFile;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmService {
    private static final String FILE_DATA_FILM = "src/bai_tap_lam_them_rap_chieu_phim/data/file_data_film.csv";
    static Scanner scanner = new Scanner(System.in);
    static Integer filmTime = 0;
    private static final List<Film> filmList;
    static {
        filmList = ReadFile.readFileFilmData(FILE_DATA_FILM);
    }

    public static void addFilm(){
        System.out.print("Add Name Film: ");
        String name = scanner.nextLine();
        System.out.print("Add time Film (minute): ");
        Integer time = IntegerInput.getIntegerInput();
        filmList.add(new Film(name,time));
        WriteFile.writeFilmListToCsv(FILE_DATA_FILM,filmList,false);
    }

    public static void displayFilmList(){
        int stt = 0;
        for (Film film : filmList){
            System.out.println("STT."+(++stt)+": "+film);
        }
    }

    public static String selectFilm() {
        displayFilmList();
        while (true){
            System.out.print("Select movie: ");
            Integer select = IntegerInput.getIntegerInput();
            for (int i = 0; i < filmList.size(); i++) {
                if(select == i+1){
                    getFilmTime(filmList.get(i).getTimeFilm());
                    return filmList.get(i).toString();
                }
            }
        }
    }

    public static void getFilmTime(Integer time){
        filmTime = time;
    }
    public static Integer filmTime (){
        return filmTime;
    }

}
