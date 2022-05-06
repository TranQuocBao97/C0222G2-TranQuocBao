package bai_tap_lam_them_rap_chieu_phim.services;


import bai_tap_lam_them_rap_chieu_phim.models.FilmShowtime;

import bai_tap_lam_them_rap_chieu_phim.utils.check_date_is_avaiable.IsADate;
import bai_tap_lam_them_rap_chieu_phim.utils.check_timeStart_with_currentTime.IsAfterCurrentTime;
import bai_tap_lam_them_rap_chieu_phim.utils.comparator_list_filmShowtime.ComparatorByTimeStartAndTimeEnd;
import bai_tap_lam_them_rap_chieu_phim.utils.get_data_input.IntegerInput;
import bai_tap_lam_them_rap_chieu_phim.utils.get_time_end_filmShowtime.TimeEnd;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.ReadFile;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.WriteFile;
import bai_tap_lam_them_rap_chieu_phim.utils.regex.RegexDateWithTime;
import bai_tap_lam_them_rap_chieu_phim.utils.regex.RegexShowtimeCode;
import bai_tap_lam_them_rap_chieu_phim.utils.stringTime_to_dayTime.StringTimeToMinuteTime;

import java.util.List;
import java.util.Scanner;

public class FilmShowtimeService {
    private static final String FILE_DATA_FILM_SHOWTIME = "src/bai_tap_lam_them_rap_chieu_phim/data/file_data_filmShowTime.csv";
    static Scanner scanner = new Scanner(System.in);
    private static final List<FilmShowtime> listFilmShowTime;
    private static final ComparatorByTimeStartAndTimeEnd comparatorByTimeStartAndTimeEnd = new ComparatorByTimeStartAndTimeEnd();
    static {
        listFilmShowTime = ReadFile.readFileFilmShowTimeData(FILE_DATA_FILM_SHOWTIME);
        listFilmShowTime.sort(comparatorByTimeStartAndTimeEnd);
    }

    public void displayAllFilmShowtime() {
        listFilmShowTime.sort(comparatorByTimeStartAndTimeEnd);
        int stt = 0;
        for (FilmShowtime filmShowtime : listFilmShowTime) {
            System.out.println("STT."+(++stt)+": "+filmShowtime);
        }
    }

    public void addFilmShowtime() {
        System.out.print("Enter code (CI-XXXX | X=number): ");
        String code = getCodeWithCheckCodeIsAvailable();
        String filmInformation = FilmService.selectFilm();
        String roomInformation = CinemaRoomService.selectRoom();
        System.out.print("Enter time start (hh:mm dd/MM/yyyy): ");
        String timeStart = checkTimeStartWithCurrentTime();
        String timeEnd = TimeEnd.getTimeEnd(timeStart,FilmService.filmTime());

        if(checkRoomAvailableWithSameTime(roomInformation,timeStart)){
            System.out.println("Add success");
        }else {
            System.out.println("Add false because same Cinema Room with same time");
            return;
        }

        listFilmShowTime.add(new FilmShowtime(code,filmInformation,roomInformation,timeStart,timeEnd));
        WriteFile.writeFilmShowtimeListToCsv(FILE_DATA_FILM_SHOWTIME,listFilmShowTime,false);
    }

    private boolean checkRoomAvailableWithSameTime(String roomInformation,String timeStart) {
        Integer timeStartNewFilmByMinute = StringTimeToMinuteTime.getDayTimeTypeMinute(timeStart);

        for(FilmShowtime filmShowtime : listFilmShowTime){
            if(roomInformation.equals(filmShowtime.getRoomInformation())){
                Integer timeEndOldFilmByMinute = StringTimeToMinuteTime.getDayTimeTypeMinute(filmShowtime.getTimeEnd());
                return timeStartNewFilmByMinute>timeEndOldFilmByMinute;
            }
        }
        return true;
    }

    private String checkTimeStartWithCurrentTime() {
        String timeStart = RegexDateWithTime.checkDateStart(scanner.nextLine());
        while (!IsADate.checkIsADate(timeStart) || !IsAfterCurrentTime.checkTimeStartWithCurrent(timeStart)){
            System.out.println("time Start need to over current time and this much be an available date!");
            System.out.print("Enter again: ");
            timeStart = RegexDateWithTime.checkDateStart(scanner.nextLine());
        }
        return timeStart;
    }

    private String getCodeWithCheckCodeIsAvailable() {
        boolean flag;
        String code;
        do {
            flag = true;
            code = RegexShowtimeCode.checkFilmShowtimeCode(scanner.nextLine());
            for (FilmShowtime filmShowtime : listFilmShowTime) {
                if (filmShowtime.getShowtimeCode().equals(code)) {
                    flag = false;
                    System.out.print("Code is available! Enter code again: ");
                    break;
                }
            }
        } while (!flag);
        return code;
    }

    public void delete(){
        displayAllFilmShowtime();
        System.out.println("Delete by showtime code");
        System.out.print("Enter showtime code: ");
        String codeForDelete = RegexShowtimeCode.checkFilmShowtimeCode(scanner.nextLine());
        for(FilmShowtime filmShowtime : listFilmShowTime){
            if(filmShowtime.getShowtimeCode().equals(codeForDelete)){

                System.out.println("Are You Sure To Delete?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                while(true){
                    System.out.print("Select: ");
                    Integer select = IntegerInput.getIntegerInput();
                    switch (select){
                        case 1:
                            listFilmShowTime.remove(filmShowtime);
                            WriteFile.writeFilmShowtimeListToCsv(FILE_DATA_FILM_SHOWTIME,listFilmShowTime,false);
                            System.out.println("Delete success");
                            return;
                        case 2:
                            return;
                        default:
                            System.out.println("Please select right number");
                    }
                }
            }
        }
    }



}
