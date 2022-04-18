package ss12_java_collection_framework.thuc_hanh.phan_biet_hashMap_hashSet;

import java.util.Objects;

public class StudentSs12ThucHanh02 {
    private String name;
    private int age;
    private String address;

    public StudentSs12ThucHanh02() {
    }

    public StudentSs12ThucHanh02(String name, int age, String address) {
        super();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
        return "Student@name=" + name + ",age=" + age + ",address=" + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSs12ThucHanh02 that = (StudentSs12ThucHanh02) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
