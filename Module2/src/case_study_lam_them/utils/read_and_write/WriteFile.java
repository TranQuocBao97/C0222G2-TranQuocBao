package case_study_lam_them.utils.read_and_write;

import case_study_lam_them.models.sub_person.Student;
import case_study_lam_them.models.sub_person.Teacher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void writerListStringToCsv(String fileDataUrl, List<String> listData, boolean flag){
        try{
            FileWriter fileWriter = new FileWriter(fileDataUrl,flag);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String data : listData){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("The File has problem");
        }
    }

    public static void writeListStudentToCsv(String fileDataUrl, List<Student> listStudent, boolean flag){
        List<String> listData = new ArrayList<>();
        for (Student student : listStudent){
            listData.add(student.toStringForCsv());
        }
        writerListStringToCsv(fileDataUrl,listData,flag);
    }

    public static void writeListTeacherToCsv(String fileDataUrl, List<Teacher> listTeacher, boolean flag){
        List<String> listData = new ArrayList<>();
        for (Teacher teacher : listTeacher){
            listData.add(teacher.toStringForCsv());
        }
        writerListStringToCsv(fileDataUrl,listData,flag);
    }
}
