package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHeapArray {
    Heap heap;
    @BeforeEach
    void setup() {
        heap = new HeapArray(10);
    }

    @Test
    void testAddElement() {
        assertNull(heap.peep());
        heap.addElement(1);
        assertEquals(((Integer)heap.peep()).intValue(), 1);
        heap.addElement(10);
        assertEquals(((Integer)heap.peep()).intValue(), 10);
        heap.addElement(5);
        assertEquals(((Integer)heap.peep()).intValue(), 10);

    }

    @Test
    void testRemoveElement() {
        assertNull(heap.removeElement());
        heap.addElement(1);
        assertEquals(((Integer)heap.removeElement()).intValue(), 1);
        heap.addElement(10);
        assertEquals(((Integer)heap.removeElement()).intValue(), 10);
        heap.addElement(8);
        heap.addElement(5);
        assertEquals(((Integer)heap.peep()).intValue(), 8);
    }

    @Test
    void testGrows() {
        Heap smallHeap = new HeapArray(1);
        heap.addElement(1);
        heap.addElement(2);
        heap.addElement(10);
        heap.addElement(5);
        assertEquals(((Integer)heap.removeElement()).intValue(), 10);
    }
}