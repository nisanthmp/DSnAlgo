package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueueArrayObj {
    Queue queue = new QueueArrayObj(5);

    @Test
    void testAddRemove() {
        assertEquals(null, queue.remove());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        queue.add("0");
        assertFalse(queue.isEmpty());
        assertEquals("0", queue.remove());
        assertTrue(queue.isEmpty());
        queue.add("0");
        queue.add("1");
        assertEquals("0", queue.remove());
        queue.add("2");
        queue.add("3");
        queue.add("4");
        assertTrue(queue.add("5"));
        assertTrue(queue.isFull());
        assertFalse(queue.add("6"));
        assertEquals("1", queue.remove());
        assertFalse(queue.isFull());


    }
}
