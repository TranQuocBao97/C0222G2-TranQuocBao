package bai_tap_lam_them_test.service;

public interface IVehicleService<E> {
    void add();
    void display();
    void delete(String id);
    boolean search(String id);
}
