package test.demo_list_student;

public class Students {
    private int id;
    private String name;
    private String address;
    private int point;
    private String school = "University";


    public Students() {
    }

    public Students(int id, String name, String address, int point) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", school='" + school + '\'' +
                '}';
    }
}