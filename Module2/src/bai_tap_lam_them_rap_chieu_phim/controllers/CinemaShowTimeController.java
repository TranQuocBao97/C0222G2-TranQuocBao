package bai_tap_lam_them_rap_chieu_phim.controllers;

import bai_tap_lam_them_rap_chieu_phim.services.CinemaRoomService;
import bai_tap_lam_them_rap_chieu_phim.services.FilmService;
import bai_tap_lam_them_rap_chieu_phim.services.FilmShowtimeService;
import bai_tap_lam_them_rap_chieu_phim.utils.get_data_input.IntegerInput;

public class CinemaShowTimeController {
    private static FilmShowtimeService filmShowtimeService = new FilmShowtimeService();
    public static void displayCinemaShowTime(){
        while (true){
            System.out.println("-----Cinema Showtime Menu-----");
            System.out.println("1. List all film Showtime ");
            System.out.println("2. Add film showtime");
            System.out.println("3. Delete film showtime by ShowtimeCode");
            System.out.println("4. Add film");
            System.out.println("5. Exit");
            System.out.print("Select: ");
            Integer select = IntegerInput.getIntegerInput();
            switch (select){
                case 1:
                    filmShowtimeService.displayAllFilmShowtime();
                    break;
                case 2:
                    filmShowtimeService.addFilmShowtime();
                    break;
                case 3:
                    filmShowtimeService.delete();
                    break;
                case 4:
                    FilmService.addFilm();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

}
