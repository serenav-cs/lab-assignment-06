import java.util.Arrays;

public class SortedLinkedList <T extends Comparable <T>> implements SortedList <T> {
    private int size;
    private Node <T>head;
    
//constructor 
    public SortedLinkedList() {
        head=null;
        this.size = 0;
    }

    @Override
    public boolean add(T item) {

        if (head == null) {
            head = new Node<>(item);
            ++size;
            return true;
        }
        Node<T> prev = head;
        Node<T> curr = head;
        while (prev.data.compareTo(item) < 0) { //comparing
            curr = prev;
            if (curr.next == null) {
                Node new_node = new Node(item);
                prev.next = new_node;
                ++size;
                return true;
            }
            prev = prev.next;
        }
        Node<T> new_node = new Node(item);
        if (head==curr) {
            new_node.next=head;
            head = new_node;
            ++size;
            return true;
        }
        new_node.next = prev;
        curr.next=new_node;
        ++size;
        return true;
    }

    @Override
    public T remove(int pos) throws Exception {
        if (pos < 0 || pos >= size)
            throw new Exception("Invalid position");

        if (pos == 0) {
            Node node = head;
            head = head.next;
            --size;
            return (T) node.data;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            --size;
            return (T) node.data;
        }

    }

    @Override
    public T get(int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new Exception("Invalid position");
        }
        Node curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return (T) curr.data;
    }

    @Override
    public int size() {
        return size;
    }




    public static void main(String[] args) throws Exception {
        SortedLinkedList sll = new SortedLinkedList();
        sll.add("10");
        sll.add("12");
        sll.add("22");
        sll.add("40");
        sll.add("1");
        sll.add("14");
       
        for (int i = 0; i < sll.size(); i++) {
            System.out.print(sll.get(i) + " ");
        }

        System.out.println(" ");
        System.out.println("this returns the fourth element in the array: " + sll.get(3)); //prints 1 since that is the number at that position

        //testing remove
        System.out.println(sll.remove(5));

        for (int i = 0; i < sll.size(); i++) {
            System.out.print(sll.get(i) + " ");
        }
        System.out.println(" ");

        //testing size function
        System.out.println("Size of Arraylist: " + sll.size());

    }
}
