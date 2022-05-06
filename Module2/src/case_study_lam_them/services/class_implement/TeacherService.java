package case_study_lam_them.services.class_implement;


import case_study_lam_them.models.sub_person.Teacher;
import case_study_lam_them.services.ITeacher;
import case_study_lam_them.utils.my_exception.NotFoundSavingException;
import case_study_lam_them.utils.read_and_write.ReadFile;
import case_study_lam_them.utils.read_and_write.WriteFile;
import case_study_lam_them.utils.regex.BirthdayRegex;
import case_study_lam_them.utils.regex.GenderRegex;
import case_study_lam_them.utils.regex.IdRegex;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {
    private Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_TEACHER = "src/case_study_lam_them/data/file_data_teacher.csv";
    private static final List<Teacher> teacherList;

    static {
        teacherList = ReadFile.readFileDataToTeacherList(FILE_DATA_TEACHER);
    }

    @Override
    public void add() {
        String id;
        do {
            System.out.print("Add Id (GV-xxxx => x=0-9): ");
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

        String expertise = scanner.nextLine();


        teacherList.add(new Teacher(id, name, birthday, gender, expertise));
        WriteFile.writeListTeacherToCsv(FILE_DATA_TEACHER, teacherList, false);
    }

    @Override
    public void delete() {
        while (true) {
            System.out.print("Delete by Id: ");
            String id = scanner.nextLine();
            try {
                checkIdForDelete(id);
                return;
            } catch (NotFoundSavingException e) {
                e.getMessage();
            }
        }
    }

    private void checkIdForDelete(String id) throws NotFoundSavingException {
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id)) {
                while (true) {
                    try {
                        System.out.println("Are you sure to delete this: ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int select = Integer.parseInt(scanner.nextLine());
                        switch (select) {
                            case 1:
                                teacherList.remove(teacher);
                                WriteFile.writeListTeacherToCsv(FILE_DATA_TEACHER, teacherList, false);
                                display();
                                return;
                            case 2:
                                return;
                        }
                    } catch (Exception e) {
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
            for (Teacher teacher : teacherList) {
                System.out.println("STT." + (++stt) + ": " + teacher);
            }
        }

        @Override
        public void search () {
            System.out.print("Search by name: ");
            String name = scanner.nextLine();
            for (Teacher teacher : teacherList) {
                if (teacher.getName().contains(name)) {
                    System.out.println(teacher);
                }
            }
        }
    }
