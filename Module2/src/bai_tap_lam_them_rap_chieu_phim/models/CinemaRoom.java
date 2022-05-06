package bai_tap_lam_them_rap_chieu_phim.models;

public class CinemaRoom {
    private String nameRoom;
    private String chairNumber;

    public CinemaRoom() {
    }

    public CinemaRoom(String nameRoom, String chairNumber) {
        this.nameRoom = nameRoom;
        this.chairNumber = chairNumber;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }

    @Override
    public String toString() {
        return "CinemaRoom{" +
                "nameRoom='" + nameRoom + '\'' +
                ", chairNumber='" + chairNumber + '\'' +
                '}';
    }

    public String toStringCsv(){
        return nameRoom+","+chairNumber;
    }
}
