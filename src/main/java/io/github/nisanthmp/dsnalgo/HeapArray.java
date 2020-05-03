package io.github.nisanthmp.dsnalgo;

public class HeapArray implements Heap {
    Object[] heapData;
    int maxSize;
    int numElements = 0;

    public HeapArray(int initialSize) {
        heapData = new Object[initialSize];
        maxSize = initialSize;
    }

    public HeapArray() {
        this(10);
    }

    @Override
    public void addElement(Object element) {
        if (numElements == maxSize) grow();
        heapData[numElements ++] = element;
        moveUp(numElements - 1);
    }

    private void grow() {
        Object[] tempData = new Object[maxSize * 2];
        System.arraycopy(heapData, 0, tempData, 0, maxSize);
        maxSize *= 2;
        heapData = tempData;
    }

    private void moveUp(int index) {
        while(((Integer)heapData[(index - 1)/2]).compareTo((Integer)heapData[index]) < 0) {
            Object temp = heapData[index];
            heapData[index] = heapData[(index -1)/2];
            heapData[(index -1)/2] = temp;
        }
    }

    @Override
    public Object removeElement() {
        Object temp = heapData[0];
        if (numElements > 0) {
            heapData[0] = heapData[--numElements];
            moveDown(0);
        }
        return temp;
    }

    private void moveDown(int index) {
        if(2*index + 2 < numElements && ((Integer)heapData[2*index + 2]).compareTo((Integer)heapData[2*index + 1]) > 0) {
            if(((Integer)heapData[2*index + 2]).compareTo((Integer)heapData[index]) > 0) {
                Object temp = heapData[index];
                heapData[index] = heapData[2*index + 2];
                heapData[2*index + 2] = temp;
                moveDown(2*index + 2);
            }
        } else if (2*index + 1 < numElements){
            if(((Integer)heapData[2*index + 1]).compareTo((Integer)heapData[index]) > 0) {
                Object temp = heapData[index];
                heapData[index] = heapData[2*index + 1];
                heapData[2*index + 1] = temp;
                moveDown(2*index + 1);
            }
        }
    }

    @Override
    public Object peep() {
        return heapData[0];
    }
}
