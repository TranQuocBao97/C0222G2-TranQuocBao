package bai_tap_lam_them_rap_chieu_phim.models;

public class Film {
    private String name;
    private Integer timeFilm;

    public Film() {
    }

    public Film(String name, Integer timeFilm) {
        this.name = name;
        this.timeFilm = timeFilm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeFilm() {
        return timeFilm;
    }

    public void setTimeFilm(Integer timeFilm) {
        this.timeFilm = timeFilm;
    }

    @Override
    public String toString() {
        return "[Film = " +
                "name: " + name +
                "; timeFilm: " + timeFilm +"]";
    }

    public String toStringCsv(){
        return name+","+timeFilm;
    }
}
