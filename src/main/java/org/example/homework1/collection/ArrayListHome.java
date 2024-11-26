package org.example.homework1.collection;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayListHome<E> implements ListCollection<E> {
    private static final int CAPACITY = 10;

    private int size = 0;
    private Object[] elements;

    public ArrayListHome() {
        elements = new Object[CAPACITY];
    }

    public ArrayListHome(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal capacity : " + capacity);
        }
    }

    @Override
    public void add(E e) {
        if (size == elements.length) {
            grow(size + 1);
        }
        elements[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);

        if (size == elements.length) {
            grow(size + 1);
        }

        Object[] elem = new Object[elements.length];

        for (int i = 0; i < index; i++) {
            elem[i] = elements[i];
        }

        elem[index] = e;

        for (int i = index + 1; i < elements.length; i++) {
            elem[i] = elements[i - 1];
        }

        size++;
        elements = elem;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return (E) elements[index];
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E oldElem = (E) elements[index];

        Object[] elem = new Object[size];

        for (int i = 0; i < index; i++) {
            elem[i] = elements[i];
        }

        for (int i = index ; i < elements.length; i++) {
            if (i + 1 > size) {
                break;
            }
            elem[i] = elements[i + 1];
        }

        elements = elem;
        size--;

        return oldElem;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        /*
        `````````````````````````````````
         */
    }

    @Override
    public E set(E e, int index) {
        checkIndex(index);

        E oldElement = (E) elements[index];
        elements[index] = e;
        return oldElement;
    }

    private void grow(int size) {
        int newCapacity = (size * 3) / 2 + 1;

        Object[] elem = new Object[newCapacity];
        copy(elem);

        elements = elem;
    }

    private void copy(Object[] objects) {
        for (int i = 0; i < size; i++) {
            objects[i] = elements[i];
        }
    }

    public void print() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    public void trimToSize(){
        Object [] elem = new Object[size];
        copy(elem);
    }
}
