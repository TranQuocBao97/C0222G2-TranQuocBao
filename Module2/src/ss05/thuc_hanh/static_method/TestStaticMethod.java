package ss05.thuc_hanh.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(1,"Nam");
        Student s2 = new Student(2,"Dinh");
        Student s3 = new Student(3,"Hoang");

        s1.display();
        s2.display();
        s3.display();
    }
}
