package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQueueLLObj {
    Queue queue = new QueueLLObj();
    @Test
    void testAddRemove() {
        assertEquals(null, queue.remove());
        queue.add("1");
        assertEquals("1", queue.remove());
        queue.add("1");
        queue.add("2");
        assertEquals("1", queue.remove());
        assertEquals("2", queue.remove());
        assertEquals(null, queue.remove());
    }
}
