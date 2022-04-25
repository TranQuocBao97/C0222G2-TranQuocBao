package case_study_2.services.class_implement.person_implement;

import case_study_2.models.person.sub_person.Employee;
import case_study_2.services.IEmployeeService;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final String FILE_DATA_EMPLOYEE = "src/case_study_2/data/File_Data_Empoyee.csv";
    static Scanner scanner = new Scanner(System.in);
    private static ReadFile readFile = new ReadFile();
    private static WriteFile writeFile = new WriteFile();


    @Override
    public void add() {
        System.out.print("Add name: ");
        String name = scanner.nextLine();
        System.out.print("Add birth: ");
        String birth = scanner.nextLine();
        System.out.print("Add gender: ");
        String gender = scanner.nextLine();
        System.out.print("Add id citizen: ");
        String idCitizen = scanner.nextLine();
        System.out.print("Add phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Add email: ");
        String email = scanner.nextLine();
        System.out.print("Add job: ");
        String job = scanner.nextLine();
        System.out.print("Add education level: ");
        String educationLevel = scanner.nextLine();
        Double salary = null;
        while (salary == null) {
            try {
                System.out.print("Add salary: ");
                salary = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please Enter Type-Number To Add Salary!");
            }
        }
        List<Employee> employeeList = new ArrayList<>();
        Integer idEmployee = checkIdEmployee();
        employeeList.add(new Employee(name, birth, gender, idCitizen, phoneNumber, email, ++idEmployee, job, educationLevel, salary));
        writeFile.writeEmployeeListToCsv(FILE_DATA_EMPLOYEE, employeeList, true);

    }

    private Integer checkIdEmployee() {
        List<Employee> employeeList = readFile.employeeListFromFileData(FILE_DATA_EMPLOYEE);
        Integer maxId = employeeList.get(0).getIdEmployee();
        for (int i = 0; i < employeeList.size(); i++) {
            if (maxId < employeeList.get(i).getIdEmployee()) {
                maxId = employeeList.get(i).getIdEmployee();
            }
        }
        return maxId;
    }

    @Override
    public void display() {
        Integer stt = 0;
        List<Employee> employeeList = readFile.employeeListFromFileData(FILE_DATA_EMPLOYEE);
        for (Employee employee : employeeList) {
            System.out.println("STT. " + (++stt) + ": "  +employee);
        }
    }

    @Override
    public void edit() {
        display();
        List<Employee> employeeList = readFile.employeeListFromFileData(FILE_DATA_EMPLOYEE);
        System.out.print("Select STT to Edit Employee: ");
        Integer checkStt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (checkStt == i + 1) {
                System.out.println(employeeList.get(i));
                System.out.print("Edit name: ");
                String name = scanner.nextLine();
                System.out.print("Edit birth: ");
                String birth = scanner.nextLine();
                System.out.print("Edit gender: ");
                String gender = scanner.nextLine();
                System.out.print("Edit id citizen: ");
                String idCitizen = scanner.nextLine();
                System.out.print("Edit phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Edit email: ");
                String email = scanner.nextLine();
                System.out.print("Edit job: ");
                String job = scanner.nextLine();
                System.out.print("Edit education level: ");
                String educationLevel = scanner.nextLine();
                Double salary = null;
                while (salary == null) {
                    try {
                        System.out.print("Edit salary: ");
                        salary = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please Enter Type-Number To Edit Salary!");
                    }
                }
                employeeList.get(i).setName(name);
                employeeList.get(i).setBirth(birth);
                employeeList.get(i).setGender(gender);
                employeeList.get(i).setIdCitizen(idCitizen);
                employeeList.get(i).setPhoneNumber(phoneNumber);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setJob(job);
                employeeList.get(i).setEducationLevel(educationLevel);
                employeeList.get(i).setSalary(salary);

            }

        }
        writeFile.writeEmployeeListToCsv(FILE_DATA_EMPLOYEE,employeeList,false);
    }
}
