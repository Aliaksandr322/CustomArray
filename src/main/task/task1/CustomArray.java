package task.task1;

import java.util.Iterator;

/**
 * This class that implements a custom array data structure with methods to add elements, add elements at a specific index,add an array of elements,
 * remove element at a specific index, remove all element from the list, as well as a method for iterating over a list
 * @param <E> the type of elements in this list
 * @author  Alexander Azaronak
 * @version 1.0
 */
public class CustomArray<E> implements Function<E>{

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    private E[] valuse;
    /**
     * The size of the CustomArray (the number of elements it contains).
     */
    private int size;

    /**
     * Shared empty array instance used for empty instances.Shared empty array instance used for empty instances.
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
    /**
     Constructs an empty list with an initial capacity of ten.
     */
    public CustomArray(){
        valuse  = (E[]) DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }
    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public CustomArray(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Negative capacity");
        }
        valuse = (E[]) new Object[capacity];
    }

    /**
     * Adds the specified element to this array list.
     *
     * @param element the element to be added to this list
     * @return {@code true} if the element has been added to the collection
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E element) {
        if(element == null){
            throw new NullPointerException("Null insert");
        }
        try {
            E[] temp = valuse;
            valuse = (E[]) new Object[valuse.length + 1];
            for(int i = 0; i < temp.length; i++){
                valuse[i] = temp[i];
            }
            valuse[valuse.length - 1] = element;
            size++;
            return true;
        }catch (ClassCastException | NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param element the element to be inserted
     * @param index the index at which the element is to be inserted
     * @return {@code true} if the element has been added to the collection
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index > size()})
     */

    public boolean addByIndex(E element, int index) {
        if(element == null){
            throw new NullPointerException("Null insert");
        }
        if(index <  0 || index > valuse.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        try {
            E[] temp = valuse;
            valuse = (E[]) new Object[valuse.length + 1];
            for(int i = 0; i < temp.length; i++){
                valuse[i] = temp[i];
            }
            valuse[index] = element;
            for (int i = index + 1; i < temp.length + 1; i++) {
                valuse[i] = temp[i - 1];  // Shift elements after the insertion index
            }
            size++;
            return true;
        }catch (ClassCastException | IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Adds all the elements of the specified array to this list.
     * The array must not contain any null elements.
     *
     * @param elements the array of elements to be added
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the array contains any null elements
     * @throws ClassCastException if the array's elements are not of the same type as this list's elements
     */
    public boolean addArray(E[] elements) {
        for(E element : elements){
            if (element == null){
                throw new NullPointerException("Array contain null");
            }
        }
        try {
            E[] temp = valuse;
            int count = 0;
            valuse = (E[]) new Object[valuse.length + elements.length];
            for(int i = 0; i < temp.length; i++){
                valuse[i] = temp[i];
                count++;
            }
            for(int i = 0; i < elements.length; i++){
                valuse[count] = elements[i];
                count++;
            }
            size+=elements.length;
            return true;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Returning the size of a given array
     * @return int size of the array
     */
    public int size() {
        return size;
    }
    /**
     * Removes the element at the specified index in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return {@code true} if the remove was successful, {@code false} otherwise
     * @throws IndexOutOfBoundsException if the index is out of bounds (index &lt; 0 || index &gt;= size())
     */
    public boolean remove(int index) {
        if(index <  0 || index > valuse.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        try {
            E[] temp = valuse;
            valuse = (E[]) new Object[valuse.length - 1];
            for(int i = 0; i < temp.length; i++) {
                if(i != index) {
                    int newIndex = i < index ? i : i - 1;
                    valuse[newIndex] = temp[i];
                }
            }
            size--;
            return true;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Removes all elements from the list. This resets the size of the list to 0.
     *
     * @return {@code true} since this operation is always successful
     */
    public boolean removeAll() {
        size = 0;
        valuse = (E[]) DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        return true;
    }
    /**
     * Gets the element at the specified index in this array.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds (index &lt; 0 || index &gt;= length)
     */
    @Override
    public E getByIndex(int index) {
        if(index <  0 || index > valuse.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return valuse[index];
    }
    /**
     * Replaces the element at the specified index in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param element the element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    @Override
    public E setIndex(int index, E element) {
        if(element == null){
            throw new NullPointerException("Null insert");
        }
        if(index <  0 || index > valuse.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E oldValue = valuse[index];
        valuse[index] = element;
        return oldValue;
    }

    /**
     * Returns a custom array iterator.
     * @return a custom array iterator
     */
    public Iterator<E> iterator() {
        return new CustomArrayIterator<>(valuse);
    }
}
