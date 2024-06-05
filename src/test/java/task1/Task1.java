package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.task1.CustomArray;
import task.task1.Function;
import task.task1.Sort;
import task.task1.Sorting;

import java.util.Comparator;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Tests for CustomArray
 * @param <E> the type of elements in this class
 * @author  Alexander Azaronak
 * @version 1.0
 */

public class Task1<E> {

    /**
     * Variable that will be initialized in each test
     */
    private Function<E> function;
    private Sorting sorting;
    /**
     * Constructor to facilitate writing tests with pre-capitalized list capacity
     */
    @BeforeEach
    public void setFunction() {
        function = new CustomArray<>(10);
        sorting = new Sort();
    }
    /**
     * Test to check whether an element is inserted correctly at the end of a list
     */
    @Test
    public void addStringTest() {
        //Given
        String addString = "Five";
        //When
        boolean isValid = function.add((E) addString);
        //Then
        Assertions.assertTrue(isValid);
    }
    /**
     * Test to check the possibility of inserting null
     */
    @Test
    public void addNull_Expected_NullPointer_Test(){
        //Given
        Object object = null;
        //When
        NullPointerException exception = assertThrows(NullPointerException.class,
                () ->
                {
                    function.add((E) object);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     * Test for checking insertion using the passed index
     */
    @Test
    public void addByIndexTest(){
        //Given
        Object object = "fwe";
        int index = 1;
        //When
        boolean isValid = function.addByIndex((E) object, index);
        //Then
        Assertions.assertTrue(isValid);

    }
    /**
     *Test to check for throwing an exception
     * @throws NullPointerException
     */
    @Test
    public void addByIndexNull_Expected_NullPointer_Test(){
        //Given
        int index = 1;
        Object object = null;
        //When
        NullPointerException exception = assertThrows(NullPointerException.class,
                () ->
                {
                    function.addByIndex((E) object,index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check for throwing an exception
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void addByIndexWithIncorrectIndex_Expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = 100;
        Object object = "qwd";
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.addByIndex((E) object,index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Array Insertion Test
     *
     */
    @Test
    public void addArrayTest(){
        //Given
        Object[] array = {"qwef", "fqwe"};
        //When
        boolean isValid = function.addArray((E[]) array);
        //Then
        Assertions.assertTrue(isValid);

    }
    /**
     *Test to check for throwing an exception with element equals null
     * @throws NullPointerException
     */
    @Test
    public void addArray_WithNullInArray_Test(){
        //Given
        Object[] array = {"qwef", null};
        //When
        NullPointerException exception = assertThrows(NullPointerException.class,
                () ->
                {
                    function.addArray((E[]) array);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     * Test to check the correctness of deletion
     */
    @Test
    public void removeTest(){
        //Given
        int index = 1;
        //When
        boolean isValid = function.remove(index);
        //Then
        Assertions.assertTrue(isValid);
    }
    /**
     *Test to check for throwing an exception with wrong index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void removeByIndex_WithIncorrectIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = 100;
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.remove(index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check for throwing an exception with negative index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void removeByIndex_WithNegativeIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = -1;
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.remove(index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     * Test to check the correctness of deletion all elements in CustomArray
     */
    @Test
    public void removeAllTest(){
        //Given
        //When
        boolean isValid = function.removeAll();
        //Then
        Assertions.assertTrue(isValid);
    }
    /**
     *Test to check whether an element is inserted at the appropriate index
     */
    @Test
    public void getByIndex_Test(){
        //Given
        int index = 2;
        String message = "fw";
        function.setIndex(index, (E) message);
        //When
        Object value = function.getByIndex(index);
        //Then
        assertEquals(value,message);
    }
    /**
     *Test to check for throwing an exception with negative index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void getByIndex_WithNegativeIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = -1;
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.getByIndex(index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check for throwing an exception with wrong index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void getByIndex_WithIncorrectIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = 100;
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.getByIndex(index);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check the insertion of an element by index
     */
    @Test
    public void setIndexByIdTest(){
        //Given
        int index = 2;
        String oldMessage = "fw";
        function.setIndex(index, (E) oldMessage);
        String newMassage = "wef";
        function.setIndex(index,(E)newMassage);
        //When
        Object value = function.getByIndex(index);
        //Then
        assertEquals(value,newMassage);
    }
    /**
     *Test to check for throwing an exception with wrong index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void setByIndex_WithIncorrectIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = 100;
        Object element = "fwe";
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.setIndex(index,(E)element);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check for throwing an exception with negative index
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void setByIndex_WithNegativeIndex_expected_IndexOutOfBoundsException_Test(){
        //Given
        int index = -2;
        Object element = "fwe";
        //When
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () ->
                {
                    function.setIndex(index,(E)element);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check for throwing an exception with element equals null
     * @throws NullPointerException
     */
    @Test
    public void setByIndex_IndexNull_Expected_NullPointer_Test(){
        //Given
        int index = 1;
        Object object = null;
        //When
        NullPointerException exception = assertThrows(NullPointerException.class,
                () ->
                {
                    function.setIndex(index, (E) object);
                }
        );
        //Then
        assertNotNull(exception.getMessage());
    }
    /**
     *Test to check simple quick sort without Comparator
     */
    @Test
    public void simpleQuickSortTest(){
        CustomArray<Integer> customArray = new CustomArray<>();
        customArray.addArray(new Integer[]{11,2,3,4,5,65});
        CustomArray<Integer> checkArray = new CustomArray();
        checkArray.addArray(new Integer[]{2,3,4,5,11,65});
        sorting.quickSort(customArray);
        boolean flag = true;
        for(int i = 0; i < checkArray.size(); i++){
            if(checkArray.getByIndex(i) != customArray.getByIndex(i)){
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }
    /**
     *Test to check simple quick sort with Comparator
     */
    @Test
    public void simpleQuickSortWithComparatorTest(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer)o1,(Integer) o2);
            }
        };
        CustomArray<Integer> customArray = new CustomArray<>();
        customArray.addArray(new Integer[]{11,2,3,4,5,65});
        CustomArray<Integer> checkArray = new CustomArray();
        checkArray.addArray(new Integer[]{2,3,4,5,11,65});
        sorting.quickSort(customArray,comparator);
        boolean flag = true;
        for(int i = 0; i < checkArray.size(); i++){
            if(checkArray.getByIndex(i) != customArray.getByIndex(i)){
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }
}
