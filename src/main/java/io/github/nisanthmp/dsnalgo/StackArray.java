package io.github.nisanthmp.dsnalgo;

import java.util.Stack;

public class StackArray {
    private int[] data;
    private final static int MAX_SIZE = 10;
    private int top = -1;
    private int stackSize;

    public StackArray() {
        this(MAX_SIZE);
    }
    public StackArray(int maxSize) {
        data = new int[maxSize];
        stackSize = maxSize;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("The stack is empty!");
            return -1;
        }
        return data[top --];
    }

    public boolean push(int element) {
        if (top == stackSize) {
            System.out.println("The stack is full!");
            return false;
        }
        data[++ top] = element;
        return true;
    }
}
