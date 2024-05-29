package main.task.task1;

import java.util.Collection;

public interface Function<E> extends Iterable<E>{

    int size();
    boolean add(E element);
    boolean addByIndex(E element , int index);
    boolean addArray(Collection<? extends E> c);
    boolean remove(int index);
    void removeAll();
    E getByIndex(int index);
}
