package case_study_lam_them.utils.read_and_write;

import case_study_lam_them.models.sub_person.Student;
import case_study_lam_them.models.sub_person.Teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String fileDataUrl){
        List<String> listData = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(fileDataUrl);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                listData.add(line);
            }
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("The File has problem");
        }
        return listData;
    }

    public static List<Student> readFileDataToStudentList(String fileDataUrl){
        List<Student> studentList = new ArrayList<>();
        List<String> listData = readFile(fileDataUrl);
        for (String dataStringLine : listData){
            String[] dataArray = dataStringLine.split(",");
            studentList.add(new Student(dataArray[0],dataArray[1],dataArray[2],dataArray[3]
                    ,dataArray[4],Integer.parseInt(dataArray[5])));
        }
        return studentList;
    }

    public static List<Teacher> readFileDataToTeacherList(String fileDataUrl){
        List<Teacher> teacherList = new ArrayList<>();
        List<String> listData = readFile(fileDataUrl);
        for(String dataStringLine : listData){
            String[] dataArray = dataStringLine.split(",");
            teacherList.add(new Teacher(dataArray[0],dataArray[1],dataArray[2],dataArray[3],dataArray[4]));
        }
        return teacherList;
    }
}
