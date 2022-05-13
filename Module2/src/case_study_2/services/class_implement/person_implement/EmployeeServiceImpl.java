package case_study_2.services.class_implement.person_implement;


import case_study_2.models.person.sub_person.Employee;
import case_study_2.services.IEmployeeService;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.take_data_input_by_condition.BirthdayOver18Under100;
import case_study_2.utils.select_property_value.EducationLevel;
import case_study_2.utils.select_property_value.Job;
import case_study_2.utils.take_data_input_by_condition.BirthdayOver18Under100Ver2;


import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_EMPLOYEE = "src/case_study_2/data/File_Data_Employee.csv";
    private static final List<Employee> employeeList;
    static {
        employeeList = ReadFile.employeeListFromFileData(FILE_DATA_EMPLOYEE);
    }



    @Override
    public void add() {
        System.out.print("Add name: ");
        String name = scanner.nextLine();
        String birth = BirthdayOver18Under100Ver2.takeBirthdayAvailable();
        System.out.print("Add gender: ");
        String gender = scanner.nextLine();
        System.out.print("Add id citizen: ");
        String idCitizen = scanner.nextLine();
        System.out.print("Add phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Add email: ");
        String email = scanner.nextLine();

        String job = Job.selectJob();

        String educationLevel = EducationLevel.selectEducationLevel();

        Double salary = null;
        while (salary == null) {
            try {
                System.out.print("Add salary: ");
                salary = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please Enter Type-Number To Add Salary!");
            }
        }
        Integer idEmployee = checkIdEmployee();
        employeeList.add(new Employee(name, birth, gender, idCitizen, phoneNumber, email, ++idEmployee, job, educationLevel, salary));
        WriteFile.writeEmployeeListToCsv(FILE_DATA_EMPLOYEE, employeeList, false);

    }

    private Integer checkIdEmployee() {
        Integer maxId = employeeList.get(0).getIdEmployee();
        for (Employee employee : employeeList) {
            if (maxId < employee.getIdEmployee()) {
                maxId = employee.getIdEmployee();
            }
        }
        if(maxId==null){
            return 1;
        }
        return maxId;
    }

    @Override
    public void display() {
        int stt = 0;
        for (Employee employee : employeeList) {
            System.out.println("STT. " + (++stt) + ": "  +employee);
        }
    }

    @Override
    public void edit() {
        display();
        System.out.print("Select STT to Edit Employee: ");
        int checkStt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (checkStt == i + 1) {
                System.out.print("Edit name: ");
                String name = scanner.nextLine();
                System.out.print("Edit birth");
                String birth = BirthdayOver18Under100Ver2.takeBirthdayAvailable();
                System.out.print("Edit gender: ");
                String gender = scanner.nextLine();
                System.out.print("Edit id citizen: ");
                String idCitizen = scanner.nextLine();
                System.out.print("Edit phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Edit email: ");
                String email = scanner.nextLine();

                String job = Job.selectJob();

                String educationLevel = EducationLevel.selectEducationLevel();

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
        WriteFile.writeEmployeeListToCsv(FILE_DATA_EMPLOYEE,employeeList,false);
    }
}
