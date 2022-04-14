package ss10_dsa_danh_sach.bai_tap.TrienKhaiLinkedList;

public class MylinkedListTest {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
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

            @Override
            public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Đạt");
        Student student2 = new Student(2,"Linh");
        Student student3 = new Student(3,"Hoa");
        Student student4 = new Student(4,"Phong");
        Student student5 = new Student(5,"Kiên");
        System.out.print(student1.getName()+" ");
        System.out.print(student2.getName()+" ");
        System.out.print(student3.getName()+" ");
        System.out.print(student4.getName()+"\n");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(1,student4);
        System.out.println("----------------------------");

        System.out.println("show origin list");
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
        System.out.println("-----------------------------");
        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();
        System.out.println("show clone list");
        for (int i = 0; i < cloneLinkedList.size(); i++) {
            Student student = (Student) cloneLinkedList.get(i);
            System.out.println(student.getName());
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }

        System.out.println("vị trí: "+myLinkedList.indexOf(student1));

        System.out.println("----------------------------");


        System.out.println("xóa :"+myLinkedList.remove(1));

        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
        System.out.println("check xóa: "+myLinkedList.remove(student1));

        System.out.println("-----------------------------");
        System.out.println(myLinkedList.contains(student2));
        System.out.println(myLinkedList.contains(student5));




    }
}
