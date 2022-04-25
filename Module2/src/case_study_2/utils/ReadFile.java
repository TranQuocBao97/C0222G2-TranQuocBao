package case_study_2.utils;

import case_study_2.models.person.sub_person.Customer;
import case_study_2.models.person.sub_person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readFile(String fileData){
        List<String> listData = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileData));
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                listData.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Cant found data or data is empty");;
        }
        return listData;
    }

    public List<Employee> employeeListFromFileData (String fileEmployee){
        List<Employee> employeesList = new ArrayList<>();
        List<String> stringDataEmployeeList = readFile(fileEmployee);

        for(String employeeProperties : stringDataEmployeeList){
            String[] array = employeeProperties.split(",");
            employeesList.add(new Employee(array[0],array[1],array[2],array[3],array[4],array[5],Integer.parseInt(array[6]),array[7],array[8],Double.parseDouble(array[9])));
        }

        return employeesList;
    }

    public List<Customer> customerListFromFileData (String fileCustomer){
        List<Customer> customerList = new ArrayList<>();
        List<String> stringDataCustomerList = readFile(fileCustomer);

        for(String customerProperties : stringDataCustomerList){
            String[] array = customerProperties.split(",");
            customerList.add(new Customer(array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8]));
        }

        return customerList;
    }
}
