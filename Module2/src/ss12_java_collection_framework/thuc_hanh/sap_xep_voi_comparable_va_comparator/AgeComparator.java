package ss12_java_collection_framework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<StudentSs12ThucHanh03> {

    @Override
    public int compare(StudentSs12ThucHanh03 o1, StudentSs12ThucHanh03 o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}
