package ss4_class_object.student_manager1.util;

import ss4_class_object.student_manager1.model.Student;
import sun.swing.StringUIClientPropertyKey;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteRead {
    public static void main(String[] args) {
        Student student = new Student(1, "chanh1", "DN", 3);
        ArrayList<Student> students =new ArrayList<>();
        students.add(new Student(1, "chanh1", "DN", 3));
        students.add(new Student(2, "chanh1", "DN", 3));
        students.add(new Student(3, "chanh1", "DN", 3));
        writeStudentToCsV(students);
        readFileCSVReturnList();



    }

    public static void writeStudentToCsV(List<Student> students) {
        File file = new File("src\\ss4_class_object\\student_manager1\\data\\student.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student s: students) {
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
            }
           bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readFileCSVReturnList(){
        List<Student> studentList = new ArrayList<>();
        File file = new File("src\\ss4_class_object\\student_manager1\\data\\student.csv");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line =null;
            while ((line =bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  studentList;
    }
}
