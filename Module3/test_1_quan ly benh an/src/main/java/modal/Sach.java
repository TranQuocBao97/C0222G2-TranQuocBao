package modal;

public class Sach {
    private String id;
    private String name;
    private String writer;
    private String information;
    private String number;

    public Sach() {
    }

    public Sach(String id, String name, String writer, String information, String number) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.information = information;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
