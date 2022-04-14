package ss10_dsa_danh_sach.bai_tap.TrienKhaiArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        MyList<Integer> myCloneList = new MyList<>();

        myList.add(0,1);
        myList.add(1,2);
        myList.add(2,5);
        myList.add(3,6);
        myList.add(4,7);
        myList.add(3,2);

        myCloneList = myList.clone();
        System.out.println("origin : "+myList);
        System.out.println("clone : "+myCloneList);


        System.out.println(myList);

        System.out.println(myList.remove(1));

        System.out.println(myList);

        System.out.println(myList.contains(1));
        System.out.println(myList.contains(3));

        System.out.println(myList.indexOf(5));
        System.out.println(myList.indexOf(3));

        System.out.println(myList.get(3));
    }
}
