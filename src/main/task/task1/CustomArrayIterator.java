package main.task.task1;

import java.util.Iterator;

public class CustomArrayIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] values;
    public CustomArrayIterator(E[] values){
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
