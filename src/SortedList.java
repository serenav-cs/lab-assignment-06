public interface SortedList <T extends Comparable<T>>{

    boolean add(T item);

    T remove(int pos) throws Exception;

    T get(int pos) throws Exception;

    int size();






}
