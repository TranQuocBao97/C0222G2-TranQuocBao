package case_study_2.utils;

import case_study_2.models.person.sub_person.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public void writeToCsvFile(String fileTakeData, List<String> dataList, boolean flag){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTakeData,flag));
            for(String lineData : dataList){
                bufferedWriter.write(lineData);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeEmployeeListToCsv (String fileTakeData, List<Employee> employeeList, boolean flag){
        List<String> dataList = new ArrayList<>();

        for(Employee employee : employeeList){
            dataList.add(employee.propertiesToCsv());
        }

        writeToCsvFile(fileTakeData,dataList,flag);
    }
}
