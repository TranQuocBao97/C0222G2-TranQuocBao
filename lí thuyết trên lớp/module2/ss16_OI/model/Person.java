package ss4_class_object.student_manager1.model;

public abstract class Person {
    protected int id;
    protected String name;
    protected String address;

    public Person() {
        System.out.println("costructor của cha không tham số");
    }

    public Person(int id, String name, String address) {
        System.out.println("constructro cha 3 tham số");
        this.id = id;
        this.name = name;
        this.address = address;
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
     void goToBy(){
        System.out.println("Đi bộ");
    }
}
