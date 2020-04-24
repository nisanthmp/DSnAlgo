package io.github.nisanthmp.dsnalgo;

public class StackLL {
    Node head = null;

    public int pop() {
        if (head == null) {
            System.out.println("The stack is empty!");
            return -1;
        }
        int element = head.element;
        head = head.next;;
        return element;
    }

    public void push(int element) {
        Node node = new Node(element, head);
        head = node;
    }
}
class Node {
    int element;
    Node next;
    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
    }
}