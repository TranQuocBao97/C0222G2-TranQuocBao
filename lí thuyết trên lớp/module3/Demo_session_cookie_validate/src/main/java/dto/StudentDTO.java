package dto;

public class StudentDTO {
    private Integer codeStudent;
    private String nameStudent;
    private Double point;
    private Integer gender;
    private String nameClass;

    public StudentDTO() {
    }

    public StudentDTO(Integer codeStudent, String nameStudent, Double point, Integer gender, String nameClass) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
        this.nameClass = nameClass;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
