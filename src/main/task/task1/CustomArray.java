package main.task.task1;

import java.util.Collection;
import java.util.Iterator;

public class CustomArray<E> implements Function<E>{

    private E[] valuse;
    private int size;

    public CustomArray(){
        valuse = (E[]) new Object[size];
    }


    public boolean add(E element) {
        try {
            E[] temp = valuse;
            valuse = (E[]) new Object[valuse.length + 1];
            System.arraycopy(temp, 0, valuse, 0 , temp.length);
            valuse[valuse.length - 1] = element;
            size++;
            return true;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }
    //TODO сделать чтобы коллекция расширялась для значения выше size (index = 10 например)
    public boolean addByIndex(E element, int index) {
        try {
            E[] temp = valuse;
            valuse = (E[]) new Object[valuse.length + 1];
            final int s = size;
            System.arraycopy(temp, 0, valuse, 0 , temp.length);
            System.arraycopy(valuse, index, valuse, index + 1, s - index);
            valuse[index] = element;
            size = s + 1;
            return true;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addArray(Collection c) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean remove(int index) {
        return false;
    }

    public void removeAll() {
        size = 0;
        valuse = (E[]) new Object[size];
    }

    public E getByIndex(int index) {
        return valuse[index];
    }


    public Iterator<E> iterator() {
        return new CustomArrayIterator<>(valuse);
    }
}
