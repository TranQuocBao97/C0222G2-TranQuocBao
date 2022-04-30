package case_study_2.utils;

import case_study_2.models.Booking;
import case_study_2.models.Contract;
import case_study_2.models.facility.sub_facility.House;
import case_study_2.models.facility.sub_facility.Room;
import case_study_2.models.facility.sub_facility.Villa;
import case_study_2.models.person.sub_person.Customer;
import case_study_2.models.person.sub_person.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteFile {
    public static void writeToCsvFile(String fileTakeData, List<String> dataList, boolean flag){
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

    public static void writeEmployeeListToCsv (String fileTakeData, List<Employee> employeeList, boolean flag){
        List<String> dataList = new ArrayList<>();

        for(Employee employee : employeeList){
            dataList.add(employee.propertiesToCsv());
        }

        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeCustomerListToCsv (String fileTakeData, List<Customer> customerList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Customer customer : customerList){
            dataList.add(customer.propertiesToCsv());
        }

        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeVillaListToCsv (String fileTakeData, Map<Villa,Integer> villaList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Map.Entry<Villa,Integer> entry : villaList.entrySet()){
            dataList.add(entry.getKey().propertiesToCsv()+","+entry.getValue().toString());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }


    public static void writeHouseListToCsv (String fileTakeData, Map<House,Integer> houseList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Map.Entry<House,Integer> entry : houseList.entrySet()){
            dataList.add(entry.getKey().propertiesToCsv()+","+entry.getValue().toString());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeRoomListToCsv (String fileTakeData, Map<Room,Integer> roomList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Map.Entry<Room,Integer> entry : roomList.entrySet()){
            dataList.add(entry.getKey().propertiesToCsv()+","+entry.getValue().toString());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeBookingListToCsv (String fileTakeData, Set<Booking> bookingList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Booking booking : bookingList){
            dataList.add(booking.propertiesToCsv());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeBookingQueueListToCsv (String fileTakeData, Queue<Booking> bookingQueueList, boolean flag){
        List<String> dataList = new LinkedList<>();

        for (Booking bookingQueue : bookingQueueList){
            dataList.add(bookingQueue.propertiesToCsv());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }

    public static void writeContractListToCsv (String fileTakeData, List<Contract> contractList, boolean flag){
        List<String> dataList = new ArrayList<>();

        for (Contract contract : contractList){
            dataList.add(contract.propertiesToCsv());
        }
        writeToCsvFile(fileTakeData,dataList,flag);
    }
}
