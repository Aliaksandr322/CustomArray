package task.task1;

import java.util.Comparator;
/**
 * This interface implements various sorting options for input CustomArray
 * @author  Alexander Azaronak
 * @version 1.0
 */
public interface Sorting {
    /**
     * This method provides the ability to sort a CustomArray without explicitly specifying sort parameters
     * @param arr  CustomArray which we want to sort
     * @param T  the type of elements in this list
     */
    public <T extends Comparable<? super T>> void quickSort(CustomArray<T> arr);
    /**
     * This method provides the ability to sort a CustomArray with explicitly specified sort options
     * @param arr  CustomArray which we want to sort
     * @param T  the type of elements in this list
     * @param comparator the type of comparator that we will be use
     */
    public <T> void quickSort(CustomArray<T> arr, Comparator<T> comparator);
}
