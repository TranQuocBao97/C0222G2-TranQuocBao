package bai_tap_lam_them_rap_chieu_phim.utils.read_and_write;

import bai_tap_lam_them_rap_chieu_phim.models.CinemaRoom;
import bai_tap_lam_them_rap_chieu_phim.models.Film;
import bai_tap_lam_them_rap_chieu_phim.models.FilmShowtime;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void writeStringListToCsv(String urlFile, List<String> dataList, boolean flag) {
        try {
            FileWriter fileWriter = new FileWriter(urlFile, flag);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String dataLine : dataList){
                bufferedWriter.write(dataLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("File has problem");
        }
    }

    public static void writeFilmListToCsv(String urlFile, List<Film> filmList,boolean flag){
        List<String> listData = new ArrayList<>();
        for (Film film : filmList){
            listData.add(film.toStringCsv());
        }
        writeStringListToCsv(urlFile,listData,flag);
    }

    public static void writeRoomListToCsv(String urlFile, List<CinemaRoom> roomList, boolean flag){
        List<String> listData = new ArrayList<>();
        for (CinemaRoom cinemaRoom : roomList){
            listData.add(cinemaRoom.toStringCsv());
        }
        writeStringListToCsv(urlFile,listData,flag);
    }

    public static void writeFilmShowtimeListToCsv(String urlFile, List<FilmShowtime> filmShowtimeList, boolean flag){
        List<String> listData = new ArrayList<>();
        for (FilmShowtime filmShowtime : filmShowtimeList){
            listData.add(filmShowtime.toStringCsv());
        }
        writeStringListToCsv(urlFile,listData,flag);
    }

}
