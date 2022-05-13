package case_study_lam_them.utils.check_id_avaiable;

import case_study_lam_them.models.Person;
import case_study_lam_them.models.sub_person.Student;
import case_study_lam_them.models.sub_person.Teacher;

import java.util.List;

public class IdAvailable {
    public static boolean checkListStudent(String id, List<Student> listToCheck){
        for(Student student : listToCheck){
            if(id.equals(student.getId())){
                System.out.println("This student id is available");
                return true;
            }
        }
        return false;
    }
    public static boolean checkListTeacher(String id, List<Teacher> listToCheck){
        for(Teacher teacher : listToCheck){
            if(id.equals(teacher.getId())){
                return true;
            }
        }
        return false;
    }
}
