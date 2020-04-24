package io.github.nisanthmp.dsnalgo;

public class StackLLObj {
    NodeObj head = null;

    public Object pop() {
        if (head == null) {
            System.out.println("Stack is empty!");
            return null;
        }
        Object element = head.element;
        head = head.next;
        return element;
    }

    public void push(Object element) {
        NodeObj node = new NodeObj(element, head);
        head = node;
    }
}

class NodeObj {

    public Object element;
    public NodeObj next;

    public NodeObj(Object element, NodeObj next) {
        this.element = element;
        this.next = next;
    }
}