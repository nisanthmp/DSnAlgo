package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSortingAlgs {
    SortingAlgs array;

    @BeforeEach
    protected void setUp() {
        array = new SortingAlgs(10);
    }

    @Test
    public void testFindElement() {
        array.addElement(0);
        assertEquals(0, array.findElement(0));
        array.addElement(1);
        assertEquals(1, array.findElement(1));
        assertEquals(0, array.findElement(0));
        array.addElement(3);
        array.addElement(4);
        array.addElement(2);
        assertEquals(4, array.findElement(2));
        assertEquals(-1, array.findElement(5));
    }

    @Test
    public void testBubbleSort() {
        array.addElement(4);
        array.bubbleSort(true);
        assertEquals(4, array.getAtIndex(0));
        array.bubbleSort(false);
        assertEquals(4, array.getAtIndex(0));
        array.addElement(1);
        array.addElement(3);
        array.addElement(4);
        array.addElement(2);
        array.addElement(0);
        array.addElement(5);
        array.bubbleSort(true);
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        // should sort an already sorted array
        array.bubbleSort(true);
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        array.randomize();
        array.display();
        array.bubbleSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));

        // should sort an already sorted array
        array.bubbleSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));
    }

    @Test
    public void testSelectionSort() {
        array.addElement(4);
        array.selectionSort(true);
        assertEquals(4, array.getAtIndex(0));
        array.selectionSort(false);
        assertEquals(4, array.getAtIndex(0));
        array.addElement(1);
        array.addElement(3);
        array.addElement(4);
        array.addElement(2);
        array.addElement(0);
        array.addElement(5);
        array.selectionSort(true);
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        // should sort an already sorted array
        array.selectionSort(true);
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        array.randomize();
        array.display();
        array.selectionSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));

        // should sort an already sorted array
        array.selectionSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));

    }

    @Test
    public void testFindElementAfterSort() {
        array.addElement(0);
        assertEquals(0, array.findElement(0));
        array.addElement(1);
        array.bubbleSort(false);
        assertEquals(0, array.findElement(1));
        assertEquals(1, array.findElement(0));
        array.addElement(3);
        array.addElement(4);
        array.addElement(2);
        array.bubbleSort(false);
        assertEquals(2, array.findElement(2));
        assertEquals(0, array.findElement(4));
        assertEquals(1, array.findElement(3));
        assertEquals(3, array.findElement(1));
        assertEquals(4, array.findElement(0));
        assertEquals(-1, array.findElement(5));

        array.bubbleSort(true);
        assertEquals(0, array.findElement(0));
        assertEquals(1, array.findElement(1));
        assertEquals(2, array.findElement(2));
        assertEquals(3, array.findElement(3));
        assertEquals(4, array.findElement(4));
        //assertEquals(4, array.getAtIndex(5));
        //assertEquals(6, array.findElement(5));

    }

    @Test
    public void testInsertionSort() {
        array.addElement(4);
        array.insertionSort(true);
        assertEquals(4, array.getAtIndex(0));
        array.insertionSort(false);
        assertEquals(4, array.getAtIndex(0));
        array.addElement(1);
        array.addElement(3);
        array.addElement(4);
        array.addElement(2);
        array.addElement(0);
        array.addElement(5);
        System.out.println("Ascending");
        array.insertionSort(true);
        array.display();
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        // should sort an already sorted array
        System.out.println("Ascending");
        array.insertionSort(true);
        assertEquals(0, array.getAtIndex(0));
        assertEquals(1, array.getAtIndex(1));
        assertEquals(2, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(4, array.getAtIndex(4));
        assertEquals(4, array.getAtIndex(5));
        assertEquals(5, array.getAtIndex(6));

        array.randomize();
        array.display();
        System.out.println("Descending");
        array.insertionSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));

        // should sort an already sorted array
        System.out.println("Descending");
        array.insertionSort(false);
        assertEquals(5, array.getAtIndex(0));
        assertEquals(4, array.getAtIndex(1));
        assertEquals(4, array.getAtIndex(2));
        assertEquals(3, array.getAtIndex(3));
        assertEquals(2, array.getAtIndex(4));
        assertEquals(1, array.getAtIndex(5));
        assertEquals(0, array.getAtIndex(6));

    }

}
