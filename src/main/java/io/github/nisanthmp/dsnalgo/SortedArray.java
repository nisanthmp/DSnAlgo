package io.github.nisanthmp.dsnalgo;

public class SortedArray {
    private int[] data;
    private int size;
    private int numElements;
    private int nearestIdx;
    private boolean extendable;
    private boolean allowsDuplicate;
    private boolean ascending;

    public SortedArray(int size) {
        this(size, true, true, false);
    }

    public SortedArray() {
        this(10, true, true, false);
    }

    public SortedArray(int size, boolean extendable, boolean allowsDuplicate, boolean ascending) {
        data  = new int[size];
        this.size = size;
        this.numElements = 0;
        this.extendable = extendable;
        this.allowsDuplicate = allowsDuplicate;
        this.ascending = ascending;
    }

    public int getSize() {
        return size;
    }
    public int sayHello() {
        System.out.println("Hello, World!");
        return 0;
    }
    public int getNumElements() {
        return numElements;
    }

    public void addElement(int element) {
        if (numElements == size) grow();
        display();
        int present = find(element, 0, numElements - 1);
        System.out.println("nearestIdx = " + nearestIdx);
        if (allowsDuplicate || present == -1) {
                for (int j = numElements; j > nearestIdx; j--) {
                    data[j] = data[j - 1];
                }
                data[nearestIdx] = element;
                numElements++;
            }
        }

        private void grow() {
            int[] newData = new int[size * 2];
            for(int i = 0; i < size; i ++) {
                newData[i] = data[i];
            }
            data = newData;
            size *= 2;
        }

        public int getFirst() {
            return data[0];
        }

        public int getAtIndex(int idx) {
            return data[idx];
        }

        public int findElement(int element) {
            return find(element, 0, numElements - 1);
        }

        private boolean compare(boolean ascending, int a, int b) {
            return ascending ? a > b : a < b;
        }

        private int find(int element, int start, int end) {
            if (start > end) {
                nearestIdx = 0;
                return -1;
            }
            int i = start + (end - start)/2;
            if (data[i] == element) {
                nearestIdx = i;
                return i;
            }
            else if (compare(ascending, data[i], element)) {
                if (i > start) return find(element, start, i - 1);
                else {
                    nearestIdx = i;
                    return -1;
                }
            }
            else {
                if (i < end) return find(element, i + 1, end);
                else {
                    nearestIdx = i + 1;
                    return -1;
                }
            }
        }

        public boolean removeElement(int element) {
            int i = findElement(element);
            if (i == -1) return false;
            else {
                for (int j = i; j < numElements - 1; j ++){
                    data[j] = data[j + 1];
                }
                numElements --;
            return true;
        }
    }

    public void display() {
        if(numElements == 0) {
            System.out.println("The array is empty!");
            return;
        }
        System.out.print(data[0]);
        for(int i = 1; i < numElements; i ++) {
            System.out.print(" " + data[i]);
        }
        System.out.print("\n");
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
