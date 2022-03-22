package com.company;

import java.util.Arrays;

public class MyList<T> {
    private int size = 0;
    private Object[] elements;

    public MyList(int dimension) {
        elements = new Object[dimension];
    }

    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }

        elements[size++] = element;
    }

    public void print() {
        for (int i = 0; i < size; ++i) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public boolean lookup(T element) {
        for (Object currElement: elements) {
            if (element.equals(currElement))
                return true;
        }

        return false;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
