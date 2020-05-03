package io.github.nisanthmp.dsnalgo;

public interface BinarySearchTree {
    boolean addElement(Object element);
    Object findElement(Object element);
    boolean removeElement(Object element);
    void inOrderTraversal();
    void preOrderTraversal();
    void postOrderTraversal();
}
