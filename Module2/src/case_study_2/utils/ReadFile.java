package case_study_2.utils;

import case_study_2.models.Booking;
import case_study_2.models.Contract;
import case_study_2.models.facility.sub_facility.House;
import case_study_2.models.facility.sub_facility.Room;
import case_study_2.models.facility.sub_facility.Villa;
import case_study_2.models.person.sub_person.Customer;
import case_study_2.models.person.sub_person.Employee;
import case_study_2.utils.comparator_booking.ComparatorBooking;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static List<String> readFile(String fileData){
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

    public static List<Employee> employeeListFromFileData (String fileEmployee){
        List<Employee> employeesList = new ArrayList<>();
        List<String> stringDataEmployeeList = readFile(fileEmployee);

        for(String employeeProperties : stringDataEmployeeList){
            String[] array = employeeProperties.split(",");
            employeesList.add(new Employee(array[0],array[1],array[2],array[3],array[4],array[5]
                    ,Integer.parseInt(array[6]),array[7],array[8],Double.parseDouble(array[9])));
        }

        return employeesList;
    }

    public static List<Customer> customerListFromFileData (String fileCustomer){
        List<Customer> customerList = new LinkedList<>();
        List<String> stringDataCustomerList = readFile(fileCustomer);

        for(String customerProperties : stringDataCustomerList){
            String[] array = customerProperties.split(",");
            customerList.add(new Customer(array[0],array[1],array[2],array[3]
                    ,array[4],array[5],array[6],array[7]));
        }
        return customerList;
    }

    public static Map<Villa,Integer> villaListFromFileData (String fileVilla){
        Map<Villa,Integer> villaList = new LinkedHashMap<>();
        List<String> stringDataVillaList = readFile(fileVilla);

        for (String VillaEntry : stringDataVillaList){
            String[] array = VillaEntry.split(",");
            villaList.put(new Villa(array[0],array[1],Double.parseDouble(array[2])
                    ,Double.parseDouble(array[3]),Double.parseDouble(array[4]),array[5],array[6]
                    ,Integer.parseInt(array[7]),array[8]),Integer.parseInt(array[9]));
        }

        return villaList;
    }

    public static Map<House,Integer> houseListFromFileData (String fileHouse){
        Map<House,Integer> houseList = new LinkedHashMap<>();
        List<String> stringDataHouseList = readFile(fileHouse);
        for (String HouseEntry : stringDataHouseList){
            String[] array = HouseEntry.split(",");
            houseList.put(new House(array[0],array[1],Double.parseDouble(array[2])
                    ,Double.parseDouble(array[3]),Double.parseDouble(array[4]),array[5],array[6]
                    ,Integer.parseInt(array[7])),Integer.parseInt(array[8]));
        }
        return houseList;
    }

    public static Map<Room,Integer> roomListFromFileData (String fileRoom){
        Map<Room,Integer> roomList = new LinkedHashMap<>();
        List<String> stringDataRoomList = readFile(fileRoom);
        for (String RoomEntry : stringDataRoomList){
            String[] array = RoomEntry.split(",");
            roomList.put(new Room(array[0],array[1],Double.parseDouble(array[2])
                    ,Double.parseDouble(array[3]),Double.parseDouble(array[4]),array[5],array[6])
                    ,Integer.parseInt(array[7]));
        }
        return roomList;
    }

    public static Set<Booking> bookingListFromFileData (String fileBooking){
        Set<Booking> bookingList = new TreeSet<>();
        List<String> stringDataBookingList = readFile(fileBooking);
        for(String bookingProperties : stringDataBookingList){
            String[] array = bookingProperties.split(",");
            bookingList.add(new Booking(array[0],array[1],array[2],array[3]));
        }
        return bookingList;
    }

    public static Queue<Booking> bookingQueueListFromFileData (String fileBookingQueue){
        Queue<Booking> bookingQueueList = new LinkedList<>();
        List<String> stringDataBookingQueueList = readFile(fileBookingQueue);
        for(String bookingQueueProperties : stringDataBookingQueueList){
            String[] array = bookingQueueProperties.split(",");
            bookingQueueList.add(new Booking(array[0],array[1],array[2],array[3]));
        }
        return bookingQueueList;
    }

    public static List<Contract> contractListFromFileDate (String fileContract){
        List<Contract> contractList = new ArrayList<>();
        List<String> stringDataContractList = readFile(fileContract);
        for (String contractProperties : stringDataContractList){
            String[] array = contractProperties.split(",");
            contractList.add(new Contract(array[0],array[1],Double.parseDouble(array[2]),Double.parseDouble(array[3])));
        }
        return contractList;
    }


}
