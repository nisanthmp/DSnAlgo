package io.github.nisanthmp.dsnalgo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSortedArray {
    SortedArray sortedArray;
    @BeforeEach
    protected void setUp() {
        sortedArray = new SortedArray(10);
    }
    @Test
    public void testSayHello(){
        assertEquals(0, sortedArray.sayHello());
    }
    @Test
    public void testConstructor() {
        assertEquals(10, sortedArray.getSize());
        assertEquals(0, sortedArray.getNumElements());
    }
    @Test
    public void testAdd() {
        sortedArray.addElement(2);
        assertEquals(2, sortedArray.getFirst());
        sortedArray.addElement(4);
        assertEquals(4, sortedArray.getFirst());
        sortedArray.addElement(3);
        assertEquals(4, sortedArray.getFirst());
    }
    @Test
    public void testGetAtIndex() {
        sortedArray.addElement(0);
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(4);
        sortedArray.addElement(2);
        assertEquals(2, sortedArray.getAtIndex(2));
        assertEquals(3, sortedArray.getAtIndex(1));
        assertEquals(0, sortedArray.getAtIndex(4));
    }
    @Test
    public void testFindElement() {
        sortedArray.addElement(0);
        assertEquals(0, sortedArray.findElement(0));
        sortedArray.addElement(1);
        assertEquals(0, sortedArray.findElement(1));
        assertEquals(1, sortedArray.findElement(0));
        sortedArray.addElement(3);
        sortedArray.addElement(4);
        sortedArray.addElement(2);
        assertEquals(2, sortedArray.findElement(2));
        assertEquals(-1, sortedArray.findElement(5));
    }
    @Test
    public void testRemoveElement() {
        sortedArray.addElement(0);
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(4);
        sortedArray.addElement(2);
        assertTrue(sortedArray.removeElement(2));
        assertFalse(sortedArray.removeElement(5));
        assertEquals(-1, sortedArray.findElement(2));
        assertEquals(-1, sortedArray.findElement(5));
        assertEquals(2, sortedArray.findElement(1));
    }
    @Test
    public void testExtendableSortedArray() {
        SortedArray extendableSortedArray = new SortedArray(1, true, true, false);
        sortedArray.addElement(2);
        assertEquals(2, sortedArray.getFirst());
        sortedArray.addElement(4);
        assertEquals(4, sortedArray.getFirst());
        sortedArray.addElement(3);
        assertEquals(4, sortedArray.getFirst());
    }

    @Test
    public void testNoDuplicate() {
        SortedArray noDupsSortedArray = new SortedArray(10, true, false, false);
        noDupsSortedArray.addElement(1);
        noDupsSortedArray.addElement(1);
        noDupsSortedArray.addElement(2);
        noDupsSortedArray.addElement(3);
        noDupsSortedArray.addElement(2);
        assertEquals(3, noDupsSortedArray.getNumElements());
    }
    @Test
    public void testSorted() {
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(2);
        assertEquals(3, sortedArray.getAtIndex(0));
        assertEquals(2, sortedArray.getAtIndex(1));
        assertEquals(1, sortedArray.getAtIndex(2));

    }
    @Test
    public void testDisplay() {
        sortedArray.display();
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(2);
        sortedArray.display();
    }

    @Test
    public void testSorting() {
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(4);
        sortedArray.addElement(6);
        sortedArray.addElement(5);
        sortedArray.display();
        assertEquals(6, sortedArray.getAtIndex(0));
        assertEquals(5, sortedArray.getAtIndex(1));
        assertEquals(4, sortedArray.getAtIndex(2));
        assertEquals(3, sortedArray.getAtIndex(3));
        assertEquals(1, sortedArray.getAtIndex(4));
    }

    @Test
    public void testAscendingSort() {
        sortedArray.setAscending(true);
        sortedArray.addElement(4);
        assertEquals(4, sortedArray.getAtIndex(0));
        sortedArray.addElement(1);
        sortedArray.addElement(3);
        sortedArray.addElement(4);
        sortedArray.addElement(2);
        sortedArray.addElement(0);
        sortedArray.addElement(5);
        assertEquals(0, sortedArray.getAtIndex(0));
        assertEquals(1, sortedArray.getAtIndex(1));
        assertEquals(2, sortedArray.getAtIndex(2));
        assertEquals(3, sortedArray.getAtIndex(3));
        assertEquals(4, sortedArray.getAtIndex(4));
        assertEquals(4, sortedArray.getAtIndex(5));
        assertEquals(5, sortedArray.getAtIndex(6));

    }
}
