package ss10_dsa_danh_sach.bai_tap.TrienKhaiArrayList;

public class MyListTest2 {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Hảo");
        Student student2 = new Student(2,"Hòa");
        Student student3 = new Student(3,"Thúy");
        Student student4 = new Student(4,"Trang");
        Student student5 = new Student(5,"Vi");
        Student student6 = new Student(6,"BoBo");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        studentMyList.add(student5);
        studentMyList.add(student6);

        System.out.println(studentMyList);
    }
}
