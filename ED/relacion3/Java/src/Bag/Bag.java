package Bag;

public interface Bag<T> extends Iterable<T> {

    boolean isEmpty();

    void insert(T x);

    int ocurrences(T x);

    void delete(T x);
}
