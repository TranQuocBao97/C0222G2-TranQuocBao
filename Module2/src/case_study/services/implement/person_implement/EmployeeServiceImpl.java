package case_study.services.implement.person_implement;


import case_study.models.person.sub_person.Employee;
import case_study.services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static public List<Employee> employeesList = new ArrayList<>();
    static Integer idEmployee = 1;

    static {
        employeesList.add(new Employee("Anh Tuấn",23,"Nam","Lễ Tân",idEmployee++));
        employeesList.add(new Employee("Nguyễn Du",25,"Nam","Bảo vệ",idEmployee++));
        employeesList.add(new Employee("Linh Ngọc",25,"Nữ","Lễ Tân",idEmployee++));
    }

    @Override
    public void add() {
        System.out.print("Add employee name: ");
        String name = scanner.nextLine();
        System.out.print("Add employee age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        System.out.print("Add employee gender: ");
        String gender = scanner.nextLine();
        System.out.print("Add employee job: ");
        String job = scanner.nextLine();
        employeesList.add(new Employee(name,age,gender,job,idEmployee++));
        display();
    }

    @Override
    public void display() {
        for(Employee employee: employeesList){
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter id employee for edit: ");
        Integer idEditEmployee = Integer.parseInt(scanner.nextLine());
        for(Employee employee: employeesList){
            if(employee.getIdEmployee().equals(idEditEmployee)){
                while (true){
                    System.out.println("found: ("+employee+")");
                    System.out.print("Edit name: ");
                    String name = scanner.nextLine();
                    System.out.print("Edit age: ");
                    Integer age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Edit gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Edit job: ");
                    String job = scanner.nextLine();
                    if(name.equals("") || age.equals(0) || gender.equals("") || job.equals("")){
                        System.out.println("Please Enter Full information");
                    }else {
                        employee.setName(name);
                        employee.setEge(age);
                        employee.setGender(gender);
                        employee.setJob(job);
                        display();
                    }
                }
            }
        }
    }
}
