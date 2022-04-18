package ss12_java_collection_framework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainSs12ThucHanh03 {
    public static void main(String[] args) {
        StudentSs12ThucHanh03 student = new StudentSs12ThucHanh03("Kien", 30, "HT");
        StudentSs12ThucHanh03 student1 = new StudentSs12ThucHanh03("Nam", 26, "HN");
        StudentSs12ThucHanh03 student2 = new StudentSs12ThucHanh03("Anh", 38, "HT");
        StudentSs12ThucHanh03 student3 = new StudentSs12ThucHanh03("Tung", 38, "HT");

        List<StudentSs12ThucHanh03> lists = new ArrayList<StudentSs12ThucHanh03>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for (StudentSs12ThucHanh03 st : lists) {
            System.out.println(st.toString());
        }


        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists, ageComparator);
        System.out.println("So sanh theo tuoi:");
        for (StudentSs12ThucHanh03 st : lists) {
            System.out.println(st.toString());
        }
    }
}
