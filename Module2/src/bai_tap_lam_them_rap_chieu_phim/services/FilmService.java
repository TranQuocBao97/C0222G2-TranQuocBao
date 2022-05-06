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


}
