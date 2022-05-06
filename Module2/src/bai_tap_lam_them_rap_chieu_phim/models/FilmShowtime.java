package bai_tap_lam_them_rap_chieu_phim.models;

public class FilmShowtime {
    private String filmInformation;
    private String cinemaRoomInformation;
    private String dateShowtime;
    private String timeShowtime;
    private String showtimeCode;

    public FilmShowtime() {
    }

    public FilmShowtime(String filmInformation, String cinemaRoomInformation, String dateShowtime, String timeShowtime, String showtimeCode) {
        this.filmInformation = filmInformation;
        this.cinemaRoomInformation = cinemaRoomInformation;
        this.dateShowtime = dateShowtime;
        this.timeShowtime = timeShowtime;
        this.showtimeCode = showtimeCode;
    }

    public String getFilmInformation() {
        return filmInformation;
    }

    public void setFilmInformation(String filmInformation) {
        this.filmInformation = filmInformation;
    }

    public String getCinemaRoomInformation() {
        return cinemaRoomInformation;
    }

    public void setCinemaRoomInformation(String cinemaRoomInformation) {
        this.cinemaRoomInformation = cinemaRoomInformation;
    }

    public String getDateShowtime() {
        return dateShowtime;
    }

    public void setDateShowtime(String dateShowtime) {
        this.dateShowtime = dateShowtime;
    }

    public String getTimeShowtime() {
        return timeShowtime;
    }

    public void setTimeShowtime(String timeShowtime) {
        this.timeShowtime = timeShowtime;
    }

    public String getShowtimeCode() {
        return showtimeCode;
    }

    public void setShowtimeCode(String showtimeCode) {
        this.showtimeCode = showtimeCode;
    }

    @Override
    public String toString() {
        return "FilmShowtime{" +
                "filmInformation='" + filmInformation + '\'' +
                ", cinemaRoomInformation='" + cinemaRoomInformation + '\'' +
                ", dateShowtime='" + dateShowtime + '\'' +
                ", timeShowtime='" + timeShowtime + '\'' +
                ", showtimeCode='" + showtimeCode + '\'' +
                '}';
    }

    public String toStringCsv(){
        return filmInformation+","+cinemaRoomInformation+","+dateShowtime+","+timeShowtime+","+showtimeCode;
    }
}
