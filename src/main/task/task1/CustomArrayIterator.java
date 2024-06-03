package task.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is necessary to implement iterating over the passed CustomArray
 * @author  Alexander Azaronak
 * @version 1.0
 */
public class CustomArrayIterator<E> implements Iterator<E> {
    /**
     * Starting index for iterating over the array
     */
    private int index = 0;
    /**
     * Default array to be iterated
     */
    private E[] values;
    /**
     *
     * @param values array to be iterated
     */
    public CustomArrayIterator(E[] values){
        this.values = values;
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the array has more elements
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }
    /**
     * Returns the next element in the array.
     *
     * @return the next element in the array
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        return values[index++];
    }
}
