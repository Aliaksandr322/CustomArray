package task.task1;

import java.util.Comparator;
/**
 * This class implements the interface Sorting to implement the quicksort method
 * @author  Alexander Azaronak
 * @version 1.0
 */
public class Sort implements Sorting{
    /**
     * Sorts the elements in the given array in ascending order using the Quick Sort algorithm.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, which must implement the {@link Comparable} interface.
     */
    public <T extends Comparable<? super T>> void quickSort(CustomArray<T> arr) {
        quickSort(arr, 0, arr.size() - 1);
    }
    /**
     * Sorts the elements in the given array in ascending order using the Quick Sort algorithm.
     *
     * This method is a helper method for the public quickSort() method and should not be called directly.
     *
     * @param arr The array to sort.
     * @param left The left index of the range to sort.
     * @param right The right index of the range to sort.
     * @param T The type of elements in the array, which must implement the {@link Comparable} interface.
     */
    private static <T extends Comparable<? super T>> void quickSort(CustomArray<T> arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }
    /**
     * Partitions the given array into two subarrays around a pivot element.
     *
     * This method is a helper method for the quickSort() methods and should not be called directly.
     *
     * @param arr The array to partition.
     * @param left The left index of the range to partition.
     * @param right The right index of the range to partition.
     * @param T The type of elements in the array, which must implement the {@link Comparable} interface.
     * @return The index of the pivot element after the partition.
     */
    private static <T extends Comparable<? super T>> int partition(CustomArray<T> arr, int left, int right) {
        T pivot = arr.getByIndex(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr.getByIndex(j).compareTo(pivot) <= 0) {
                i++;
                T temp = arr.getByIndex(i);
                arr.setIndex(i, arr.getByIndex(j));
                arr.setIndex(j, temp);
            }
        }
        T temp = arr.getByIndex(i + 1);
        arr.setIndex(i + 1, arr.getByIndex(right));
        arr.setIndex(right, temp);
        return i + 1;
    }
    /**
     * Sorts the given CustomArray using the QuickSort algorithm.
     *
     * @param <T>        the type of elements in the array
     * @param arr        the CustomArray to be sorted
     * @param comparator the comparator used to compare elements of the array
     */
    public <T> void quickSort(CustomArray<T> arr, Comparator<T> comparator) {
        quickSort(arr, 0, arr.size() - 1, comparator);
    }
    /**
     * Recursively sorts the subarray defined by the given left and right indices using the QuickSort algorithm.
     *
     * @param <T>        the type of elements in the array
     * @param arr        the CustomArray to be sorted
     * @param left       the starting index of the subarray to be sorted
     * @param right      the ending index of the subarray to be sorted
     * @param comparator the comparator used to compare elements of the array
     */
    private static <T> void quickSort(CustomArray<T> arr, int left, int right, Comparator<T> comparator) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right, comparator);
        quickSort(arr, left, pivotIndex - 1, comparator);
        quickSort(arr, pivotIndex + 1, right, comparator);
    }
    /**
     * Partitions the subarray defined by the given left and right indices around a pivot element.
     * Elements less than or equal to the pivot are moved to the left of the pivot, and elements greater than the pivot
     * are moved to the right of the pivot.
     *
     * @param <T>        the type of elements in the array
     * @param arr        the CustomArray to be partitioned
     * @param left       the starting index of the subarray to be partitioned
     * @param right      the ending index of the subarray to be partitioned
     * @param comparator the comparator used to compare elements of the array
     * @return the index of the pivot element after partitioning
     */
    private static <T> int partition(CustomArray<T> arr, int left, int right, Comparator<T> comparator) {
        T pivot = arr.getByIndex(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparator.compare(arr.getByIndex(j), pivot) <= 0) {
                i++;
                T temp = arr.getByIndex(i);
                arr.setIndex(i, arr.getByIndex(j));
                arr.setIndex(j, temp);
            }
        }
        T temp = arr.getByIndex(i + 1);
        arr.setIndex(i + 1, arr.getByIndex(right));
        arr.setIndex(right, temp);
        return i + 1;
    }
}
