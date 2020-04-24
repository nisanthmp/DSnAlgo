package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStackLL {
    private StackLL stack;

    @BeforeEach
    public void initialize() {
        stack = new StackLL();
    }

    @Test
    public void testPushAndPop() {
        stack.pop();
        stack.push(0);
        assertEquals(0, stack.pop());
        stack.push(0);
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals(0, stack.pop());
    }

}
