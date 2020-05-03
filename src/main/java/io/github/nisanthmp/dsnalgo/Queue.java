package io.github.nisanthmp.dsnalgo;

public interface Queue {
    boolean add(Object element);
    Object remove();
    boolean isEmpty();
    boolean isFull();
}
