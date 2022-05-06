package bai_tap_lam_them_rap_chieu_phim.models;

public class FilmShowtime {
    private String showtimeCode;
    private String filmInformation;
    private String roomInformation;
    private String timeStart;
    private String timeEnd;

    public FilmShowtime() {
    }

    public FilmShowtime(String showtimeCode, String filmInformation, String roomInformation, String timeStart, String timeEnd) {
        this.showtimeCode = showtimeCode;
        this.filmInformation = filmInformation;
        this.roomInformation = roomInformation;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getShowtimeCode() {
        return showtimeCode;
    }

    public void setShowtimeCode(String showtimeCode) {
        this.showtimeCode = showtimeCode;
    }

    public String getFilmInformation() {
        return filmInformation;
    }

    public void setFilmInformation(String filmInformation) {
        this.filmInformation = filmInformation;
    }

    public String getRoomInformation() {
        return roomInformation;
    }

    public void setRoomInformation(String roomInformation) {
        this.roomInformation = roomInformation;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "FilmShowtime[" +
                "showtimeCode: " + showtimeCode +
                ", filmInformation: " + filmInformation +
                ", roomInformation: " + roomInformation +
                ", timeStart: " + timeStart +
                ", timeEnd: " + timeEnd+"]";
    }

    public String toStringCsv(){
        return showtimeCode+","+filmInformation+","+roomInformation+","+timeStart+","+timeEnd;
    }
}
