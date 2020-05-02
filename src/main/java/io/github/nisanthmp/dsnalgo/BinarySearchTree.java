package io.github.nisanthmp.dsnalgo;

public interface BinarySearchTree {
    public boolean addElement(Object element);
    public Object findElement(Object element);
    public boolean removeElement(Object element);
    public void inOrderTraversal();
    public void preOrderTraversal();
    public void postOrderTraversal();
}
