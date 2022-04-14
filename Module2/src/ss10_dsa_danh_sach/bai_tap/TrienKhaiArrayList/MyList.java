package ss10_dsa_danh_sach.bai_tap.TrienKhaiArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        if(capacity>=0){
            elements = new Object[capacity];
        }else {
            throw new IllegalArgumentException("capacity :"+capacity);
        }

    }

    private void checkIndex(int index) {
        if(index <0 || index >size){
            throw new IndexOutOfBoundsException("Out of range, your index ="+ index +", max size ="+size+" ");
        }
    }

    public void add(int index,E e){
        ensureCapacity();
        checkIndex(index);
        for (int i = size-1; i >= index; i--){
            elements[i+1]=elements[i];
        }
        elements[index] =  e;
        size++;
    }

    public boolean add(E e){
        ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }


    public E remove(int index){
        checkIndex(index);
        E e = (E) elements[index];
        for (int i = index; i <size-1 ; i++) {
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return e;
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        size = 0;
        Arrays.fill(elements, null);
    }

    public MyList<E> clone(){
        MyList<E> newArray = new MyList<>();
        newArray.elements = Arrays.copyOf(elements, elements.length);
        newArray.size = size;
        return newArray;
    }

    public boolean contains (E e){
        return this.indexOf(e) >=0;
    }

    public int indexOf (E e){
        for (int i = 0; i < size; i++) {
            if(e.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    public E get (int index){
        checkIndex(index);
        E e = (E) elements[index];
        return e;
    }

    private void ensureCapacity() {
        if(size>=elements.length){
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
