package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStackLLObj {
    StackLLObj stack = new StackLLObj();

    @Test
    void testPushAndPop() {
        assertEquals(null, stack.pop());
        stack.push("1");
        assertEquals("1", stack.pop());
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
        assertEquals(null, stack.pop());

    }
}
