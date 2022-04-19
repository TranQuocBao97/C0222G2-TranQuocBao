package bai_tap_lam_them_oop_1_fix.service;

public interface IVehicleService<E> {
    void add();
    void display();
    void delete(String id);
    boolean search(String id);
}
