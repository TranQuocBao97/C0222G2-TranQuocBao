package ss12_java_collection_framework.thuc_hanh.phan_biet_hashMap_hashSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainSs12ThucHanh02 {
    public static void main(String[] args) {
        StudentSs12ThucHanh02 student1 = new StudentSs12ThucHanh02("Nam",20, "HN");
        StudentSs12ThucHanh02 student2 = new StudentSs12ThucHanh02("Hung",21, "HN");
        StudentSs12ThucHanh02 student3 = new StudentSs12ThucHanh02("Ha",22, "HN");
        StudentSs12ThucHanh02 student4 = new StudentSs12ThucHanh02("Ha",22, "HN");

        // write your code here
        Map<Integer, StudentSs12ThucHanh02> studentMap = new HashMap<Integer, StudentSs12ThucHanh02>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);



        for(Map.Entry<Integer, StudentSs12ThucHanh02> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<StudentSs12ThucHanh02> students = new HashSet<StudentSs12ThucHanh02>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);
        students.add(student4);

        for(StudentSs12ThucHanh02 student : students){
            System.out.println(student.toString());
        }
    }
}
