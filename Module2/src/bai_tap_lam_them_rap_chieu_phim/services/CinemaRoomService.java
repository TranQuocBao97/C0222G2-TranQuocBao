package bai_tap_lam_them_rap_chieu_phim.services;

import bai_tap_lam_them_rap_chieu_phim.models.CinemaRoom;
import bai_tap_lam_them_rap_chieu_phim.utils.get_data_input.IntegerInput;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.ReadFile;
import bai_tap_lam_them_rap_chieu_phim.utils.read_and_write.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaRoomService {
    private static final String FILE_DATA_CINEMA_ROOM = "src/bai_tap_lam_them_rap_chieu_phim/data/file_data_cinemaRoom.csv";
    static Scanner scanner = new Scanner(System.in);
    private static final List<CinemaRoom> roomList = new ArrayList<>();
    static {
        roomList.add(new CinemaRoom("Room1",150));
        roomList.add(new CinemaRoom("Room2",150));
        roomList.add(new CinemaRoom("Room3",200));
        roomList.add(new CinemaRoom("Room4",200));
        roomList.add(new CinemaRoom("Room5",250));
    }
    public static void displayCinemaRoom(){
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println("STT."+(i+1)+": "+roomList.get(i));
        }
    }
    public static String selectRoom(){
        displayCinemaRoom();
        while (true){
            System.out.print("Select the Cinema Room: ");
            Integer select = IntegerInput.getIntegerInput();
            for (int i = 0; i < roomList.size(); i++) {
                if(select==i+1){
                    return roomList.get(i).toString();
                }
            }
        }
    }


}
