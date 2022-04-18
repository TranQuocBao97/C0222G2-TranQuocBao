package ss12_java_collection_framework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

public class StudentSs12ThucHanh03 implements Comparable<StudentSs12ThucHanh03>{
    private String name;
    private Integer age;
    private String address;

    public StudentSs12ThucHanh03(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "name='" + name;
    }


    @Override
    public int compareTo(StudentSs12ThucHanh03 student) {
        return this.getName().compareTo(student.getName());
    }

}
