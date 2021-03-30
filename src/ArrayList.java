import java.util.Arrays;

public  class ArrayList <T extends Comparable <T>> implements SortedList <T>{

    public T[] sortedArr;
    public  int size;

    //constructor
    public ArrayList() {
        sortedArr = (T[]) new Comparable[10];
        this.size = 0;
    }


    @Override
    public boolean add(T item) {
        // TODO:  MAKE SURE TO SORT THE ARRAY AS YOU ADD ELEMENTS
        //insertion sort
//        if (size == sortedArr.length) { //checks if there is enough space to add, if not, then resize the array
//            grow_array();
//        }
//        sortedArr[size++]=item;
//        return true;

        if (size == sortedArr.length) {
            grow_array();
        }
        // if ArrayList is size 0. Simply just add the item
        if (size == 0) {
            sortedArr[size++] = item;
            return true;
        }
        int i = size-1;
        size++;
        // use compareTo methods to add elements in ascending order
        while (sortedArr[i].compareTo(item) > 0) {
            sortedArr[i+1] = sortedArr[i];
            if (i > 0) {
                i--;
            } else {
                sortedArr[i] = item;
                return true;
            }
        }
        sortedArr[i+1] = item;
        return true;
    }

    private void grow_array() {
        int length=sortedArr.length;
        T[] new_array= (T[]) new Comparable[length * 2];
        for(int i=0;i<sortedArr.length;i++){
            new_array[i]=sortedArr[i];
        }
        sortedArr=new_array;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size)
            //throw new Exception("Invalid Position");
            System.out.println("INVALID position-remove");

        T item = sortedArr[pos];
        for (int i = pos; i < size - 1; i++){
            sortedArr[i] = sortedArr[i + 1];
        }
        size-=1; //decrement the size
        return item;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size)
            //throw new Exception("Invalid Position");
            System.out.println("INVALID position-get");

        return sortedArr[pos];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "sortedArr=" + Arrays.toString(sortedArr) +
                ", size=" + size +
                '}';
    }


    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(44);
        al.add(12);
        al.add(10);
        al.add(22);
        al.add(1);
        al.add(5);
        al.add(6);
        for(int i=0; i < al.size(); i++){
            System.out.print( al.get(i) +" ");
        }
        System.out.println(" ");

        System.out.println("this returns the second element in the array: " + al.get(1)); //prints 1 since that is the number at that position
//
        //testing remove
        System.out.println("this removed item: " + al.remove(5));
        //System.out.println(a1);

        for(int i=0; i < al.size(); i++){
            System.out.print( al.get(i)+ " " );
        }
        System.out.println(" ");
//
        //testing size
        System.out.println("Size of Arraylist: " + al.size());
    }
}
