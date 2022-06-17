package program.model;

public class Music {
    private Integer id;
    private String name;
    private String singer;
    private String link;

    public Music() {
    }

    public Music(Integer id, String name, String singer, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
