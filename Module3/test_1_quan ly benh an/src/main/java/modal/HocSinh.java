package modal;

public class HocSinh {
    private String id;
    private String name;
    private String lop;

    public HocSinh() {
    }

    public HocSinh(String id, String name, String lop) {
        this.id = id;
        this.name = name;
        this.lop = lop;
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

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
