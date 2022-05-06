package bai_tap_lam_them_rap_chieu_phim.utils.read_and_write;

import bai_tap_lam_them_rap_chieu_phim.models.CinemaRoom;
import bai_tap_lam_them_rap_chieu_phim.models.Film;
import bai_tap_lam_them_rap_chieu_phim.models.FilmShowtime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile (String urlFileData){
        List<String> listData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(urlFileData);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                listData.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File has problem");;
        }
        return listData;
    }

    public static List<Film> readFileFilmData(String urlFileData){
        List<String> listData = readFile(urlFileData);
        List<Film> filmList = new ArrayList<>();
        for(String dataLine : listData){
            String[] array = dataLine.split(",");
            filmList.add(new Film(array[0],Integer.parseInt(array[1])));
        }
        return filmList;
    }

    public static List<CinemaRoom> readFileRoomData(String urlFileData){
        List<String> listData = readFile(urlFileData);
        List<CinemaRoom> roomList = new ArrayList<>();
        for (String dataLine : listData){
            String[] array = dataLine.split(",");
            roomList.add(new CinemaRoom(array[0],array[1]));
        }
        return roomList;
    }

    public static List<FilmShowtime> readFileFilmShowTimeData(String urlFileData){
        List<String> listData = readFile(urlFileData);
        List<FilmShowtime> filmShowtimeList = new ArrayList<>();

        for (String dataLine : listData){
            String[] array = dataLine.split(",");
            filmShowtimeList.add(new FilmShowtime(array[0],array[1],array[2],array[3],array[4]));
        }
        return filmShowtimeList;
    }


}
