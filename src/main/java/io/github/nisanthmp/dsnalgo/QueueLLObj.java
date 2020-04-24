package io.github.nisanthmp.dsnalgo;

public class QueueLLObj implements Queue {
    NodeObj front = null;
    NodeObj back = null;

    @Override
    public Object remove() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return null;
        }
        Object element = front.element;
        front = front.next;
        if (front == null) {
            back = null;
        }
        return  element;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public boolean add(Object element) {
        NodeObj node = new NodeObj(element, null);
        if (back != null) {
            back.next = node;
        }
        back = node;
        if (front == null) {
            front = back;
        }
        return true;
    }
}
