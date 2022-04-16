package bai_tap_lam_them.service;

import java.util.Scanner;

public interface InterfaceVehicleService{
    Scanner scanner = new Scanner(System.in);

    void add();
    void display();
    void delete(int id);
    boolean search(int id);
}
