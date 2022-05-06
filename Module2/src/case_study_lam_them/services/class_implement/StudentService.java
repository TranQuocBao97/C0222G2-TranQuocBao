package case_study_lam_them.services.class_implement;

import case_study_lam_them.models.sub_person.Student;
import case_study_lam_them.services.IStudent;
import case_study_lam_them.utils.my_exception.NotFoundSavingException;
import case_study_lam_them.utils.read_and_write.ReadFile;
import case_study_lam_them.utils.read_and_write.WriteFile;
import case_study_lam_them.utils.regex.BirthdayRegex;
import case_study_lam_them.utils.regex.GenderRegex;
import case_study_lam_them.utils.regex.IdRegex;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_STUDENT = "src/case_study_lam_them/data/file_data_student.csv";
    private static final List<Student> studentList;

    static {
        studentList = ReadFile.readFileDataToStudentList(FILE_DATA_STUDENT);
    }

    @Override
    public void add() {
        String id;
        do {
            System.out.print("Add Id (SV-xxxx => x=0-9): ");
            id = scanner.nextLine();
        } while (!IdRegex.checkStudentId(id));

        System.out.print("Add name: ");
        String name = scanner.nextLine();

        String birthday;
        do {
            System.out.print("Add birthday (dd/MM/yyyy): ");
            birthday = scanner.nextLine();
        } while (!BirthdayRegex.checkBirthday(birthday));

        String gender;
        do {
            System.out.print("Add gender (Male | Female | Other): ");
            gender = scanner.nextLine();
        } while (!GenderRegex.checkGender(gender));

        System.out.print("Add className: ");
        String className = scanner.nextLine();
        boolean flag = false;
        Integer mark = null;
        while (!flag) {
            try {
                System.out.print("Add mark (number): ");
                mark = Integer.parseInt(scanner.nextLine());
                flag = true;
            } catch (Exception e) {
                System.out.println("Enter mark by number");
            }
        }

        studentList.add(new Student(id, name, birthday, gender, className, mark));
        WriteFile.writeListStudentToCsv(FILE_DATA_STUDENT, studentList, false);
    }

    @Override
    public void delete() {
        while (true){
            System.out.print("Delete by Id: ");
            String id = scanner.nextLine();
            try{
                checkIdForDelete(id);
                return;
            }catch (NotFoundSavingException e){
                e.getMessage();
            }
        }
    }

    private void checkIdForDelete(String id) throws NotFoundSavingException {
        for(Student student : studentList){
            if(student.getId().equals(id)){
                while(true){
                    try{
                        System.out.println("Are you sure to delete this: ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int select = Integer.parseInt(scanner.nextLine());
                        switch (select){
                            case 1:
                                studentList.remove(student);
                                WriteFile.writeListStudentToCsv(FILE_DATA_STUDENT, studentList, false);
                                display();
                                return;
                            case 2:
                                return;
                        }
                    }catch (Exception e){
                        System.out.println("Please select right number");
                    }
                }
            }
        }
        throw new NotFoundSavingException();
    }

    @Override
    public void display() {
        int stt = 0;
        for (Student student : studentList) {
            System.out.println("STT." + (++stt) + ": " + student);
        }
    }

    @Override
    public void search() {
        System.out.print("Search by name: ");
        String name = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getName().contains(name)) {
                System.out.println(student);
            }
        }
    }
}
