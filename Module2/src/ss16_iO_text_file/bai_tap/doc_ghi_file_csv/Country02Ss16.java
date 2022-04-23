package ss16_iO_text_file.bai_tap.doc_ghi_file_csv;

public class Country02Ss16 {
    private int id;
    private String code;
    private String name;

    public Country02Ss16() {
    }

    public Country02Ss16(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String eachPropertiesToCsv(){
        return id+","+code+","+name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
