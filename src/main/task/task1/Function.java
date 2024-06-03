package task.task1;

/**
 * This interface provides methods for working with a custom ArrayList analogue
 * @author  Alexander Azaronak
 * @version 1.0
 */
public interface Function<E> extends Iterable<E>{
    /**
     * This method returns the number of elements in the array
     * @return will return the number of elements in the array
     */
    int size();
    /**
     * This method expands the array and adds an element to the end of the array
     * @param element element that will be placed in the array
     * @return true if the element was inserted successfully
     */
    boolean add(E element);
    /**
     * This method expands the array and adds an element at the specified index.
     * @param element element that will be placed in the array
     * @param index index where the element will be placed
     * @return true if the element was inserted successfully
     */
    boolean addByIndex(E element , int index);
    /**
     * This method takes an array and adds its entire value to the end of the array.
     * @param elements element that will be placed in the array
     * @return true if the elements were inserted successfully
     */
    boolean addArray(E[] elements);
    /**
     * This method removes an element from an array at the corresponding index
     * @param index index of the element to be deleted
     * @return true if the element was deleted successfully
     */
    boolean remove(int index);
    /**
     * This method removes all element from an array
     * @return true if the element was deleted successfully
     */
    boolean removeAll();
    /**
     * This method allows you to get a specific element from an array at a given index
     * @param E the element that will be returned at the corresponding index
     * @param index index of the element to be got
     */
    E getByIndex(int index);
    /**
     * This method allows you to change an existing element to a new one at the corresponding index
     * @param E the element that will be returned at the corresponding index
     * @param element new element to replace
     * @param index index to replace element
     */
    E setIndex(int index, E element);
}
