package io.github.nisanthmp.dsnalgo;

public class SortingAlgs {
    private int[] data;
    private int size;
    private int numElements;
    private int nearestIdx;
    private boolean extendable;
    private boolean sorted;
    private boolean ascending;

    public SortingAlgs(int size) {
        this(size, true);
    }

    public SortingAlgs() {
        this(10, true);
    }

    public SortingAlgs(int size, boolean extendable) {
        data  = new int[size];
        this.size = size;
        this.numElements = 0;
        this.extendable = extendable;
        this.sorted = false;
    }
    public int getSize() {
        return size;
    }
    public int getNumElements() {
        return numElements;
    }

    public void addElement(int element) {
        if (numElements == size) grow();
        data[numElements ++] = element;
        sorted = false;
    }

    private void grow() {
        int[] newData = new int[size * 2];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
        size *= 2;
    }

    public int getAtIndex(int idx) {
        return data[idx];
    }

    public boolean isSorted() {
        return sorted;
    }
    public int findElement(int element) {
        if (isSorted()) return find(element, 0, numElements - 1);
        else {
            for (int i = 0; i < numElements; i ++) {
                if (data[i] == element) return i;
            }
            return -1;
        }
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

    private boolean compare(boolean ascending, int a, int b) {
        return ascending ? a > b : a < b;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void bubbleSort(boolean ascending) {
        this.ascending = ascending;
        for (int i = 0; i < numElements; i ++) {
            for (int j = 0; j < numElements - i - 1; j ++) {
                if (compare(ascending, data[j], data[j + 1])) swap(j, j + 1);
            }
        }
        sorted = true;
    }

    public void randomize() {
        for (int i = 0; i < numElements; i ++) {
            int j = (int)(Math.random() * numElements);
            swap(i, j);
        }
        sorted = false;
    }

    public void selectionSort(boolean ascending) {
        this.ascending = ascending;
        for (int i = 0; i < numElements; i ++) {
            int selected = 0;
            for (int j = 1; j < numElements - i; j ++) {
                if(compare(ascending, data[j], data[selected])) selected = j;
            }
            swap(selected, numElements - i - 1);
        }
        sorted = true;
    }

    public void insertionSort(boolean ascending) {
        this.ascending = ascending;
        display();
        for (int i = 1; i < numElements; i ++) {
            int temp = data[i];
            find(temp, 0, i - 1);
            for (int j = i; j > nearestIdx; j --) {
                data[j] = data[j - 1];
            }
            data[nearestIdx] = temp;
            display();
        }
        sorted = true;
    }
}
