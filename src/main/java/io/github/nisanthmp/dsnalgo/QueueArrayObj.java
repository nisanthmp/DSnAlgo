package io.github.nisanthmp.dsnalgo;

public class QueueArrayObj implements Queue {
    private Object[] data;
    private boolean isEmpty = true;
    private int front = 0;
    private int back = 0;
    private int size = 0;

    public QueueArrayObj() {
        this(10);
    }
    public QueueArrayObj(int size) {
        data = new Object[size];
        this.size = size;
    }

    @Override
    public Object remove() {
        if (isEmpty) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            Object temp = data[front];
            front = (front + 1) % size;
            if (front == back) isEmpty = true;
            return temp;
        }
    }

    @Override
    public boolean add(Object s) {
        if(isEmpty || front != back) {
            data[back] = s;
            back = (back + 1) % size;
            isEmpty = false;
            return true;
        }
        else {
            System.out.println("Queue is full!");
            return false;
        }

    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public boolean isFull() {
        return !isEmpty && front == back;
    }
}
