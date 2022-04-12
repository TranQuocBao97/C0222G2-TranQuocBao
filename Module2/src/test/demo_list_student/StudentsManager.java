package test.demo_list_student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsManager {
    ArrayList<Students> students = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    

    public void availableStudent(){
        students.add(new Students(1,"Bao","QN",10));
        students.add(new Students(2,"Khoi","DN",5));
        students.add(new Students(3,"Tuan","DN",8));
    }
    public void add(){
        System.out.print("Add ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Add name the student :");
        String name = input.nextLine();
        System.out.print("Add address the student :");
        String address = input.nextLine();
        System.out.print("Add the point by this student: ");
        int point = Integer.parseInt(input.nextLine());
        students.add(new Students(id,name,address,point));
    }

    public void update(){
        System.out.print("Pick the id you want to update: ");
        int pickUpdateID = Integer.parseInt(input.nextLine());
        boolean confirm = false;
        for(Students students: students){
            if (students.getId() == pickUpdateID) {
                System.out.print("Update the name: ");
                String updateName = input.nextLine();
                students.setName(updateName);
                System.out.print("Update the address: ");
                String updateAddress = input.nextLine();
                students.setAddress(updateAddress);
                System.out.print("Update the point: ");
                int updatePoint = Integer.parseInt(input.nextLine());
                students.setPoint(updatePoint);
                confirm = true;
                break;
            }
        }
        if(confirm){
            System.out.println("Updated for id: "+pickUpdateID);
        }else {
            System.out.println("Your id not exist");
        }
    }

    public void delete(){
        System.out.print("Pick the id you want to delete: ");
        int pickDeleteID = Integer.parseInt(input.nextLine());
        boolean confirmDelete = false;
        for(Students student : students){
            if(student.getId()==pickDeleteID){
                students.remove(student);
                confirmDelete = true;
                break;
            }
        }
        if(confirmDelete){
            System.out.println("The date of student with id "+pickDeleteID+" was deleted");
        }else {
            System.out.println("Your id not exist");
        }
    }
    public void search(){
        System.out.print("Pick the id you want to search: ");
        int pickSearchID = Integer.parseInt(input.nextLine());
        for(Students student : students){
            if(student.getId()==pickSearchID){
                System.out.println(student);
            }
        }
    }
    public void display(){
        for (Students student : students) {
            System.out.println(student);
        }
    }
}
