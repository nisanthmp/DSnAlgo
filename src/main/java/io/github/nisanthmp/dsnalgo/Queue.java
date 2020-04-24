package io.github.nisanthmp.dsnalgo;

public interface Queue {
    public boolean add(Object element);
    public Object remove();
    public boolean isEmpty();
    public boolean isFull();
}
