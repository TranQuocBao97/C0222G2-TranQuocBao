package ss10_dsa_danh_sach.bai_tap.TrienKhaiLinkedList;

public class MyLinkedList<E> {

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        checkIndex(index);
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public Object get(int index) {
        checkIndex(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public E remove(int index) {
        checkIndex(index);
        Node temp = head;
        Object data;
        if(index==0){
            data = temp.data;
            head = head.next;
            numNodes--;
        }else{
            for (int i =0; i<index-1 && temp.next!=null;i++ ){
                temp=temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove(E element){
        if(head.data.equals(element)){
            remove(0);
            return true;
        }else {
            Node temp = head;
            while (temp.next != null){
                if(temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return true;
    }

    public int indexOf(E element){
        Node temp = head;
        if(temp.getData().equals(element)){
            return 0;
        }
        for (int i = 1; i < numNodes; i++) {
            temp = temp.next;
            if(temp.getData().equals(element)){
                return i;
            }
        }
        return -1;
    }

    public MyLinkedList<E> clone(){
        if(numNodes==0){
            throw new IndexOutOfBoundsException("LinkedList này null");
        }
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null){
            returnLinkedList.addLast((E) temp.data);
            temp=temp.next;
        }
        return returnLinkedList;
    }

    public boolean contains (E element){
        Node temp = head;
        while (temp.next != null){
            if(temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Out of range, your index =" + index + ", max size =" + numNodes + " ");
        }
    }
}
