package ss10_dsa_danh_sach.thuc_hanh.trien_khai_lop_linkedlist_don_gian;

import java.util.Objects;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);

        myLinkedList.add(1,3);
        myLinkedList.add(1,2);

        myLinkedList.addFirst(1);
        myLinkedList.addFirst(6);



        myLinkedList.printList();


    }
}
