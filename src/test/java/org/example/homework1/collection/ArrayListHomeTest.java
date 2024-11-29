package org.example.homework1.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListHomeTest<E> {
    @Test
    void addTest() {
        ArrayListHome<Integer> arrayListHome = new ArrayListHome<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayListHome.add(i);
        }
    }

    @Test
    void addElementTest() {
        ArrayListHome<Integer> arrayListHome = new ArrayListHome<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayListHome.add(i, i);
        }
    }

    @Test
    void getTest() {
        ArrayListHome<String> arrayListHome = new ArrayListHome<>(10000) {
        };
        for (int i = 0; i < 10000; i++) {
            arrayListHome.get(i);
        }
    }

    @Test
    void removeTest() {
        ArrayListHome<Character> arrayListHome = new ArrayListHome<>();
        for (int i = 0; i < 5000; i++) {
            arrayListHome.add((char) i);
        }

        for (int i = 0; i < 5000; i++) {
            arrayListHome.remove(i);
        }
    }

    @Test
    void clearTest() {
        ArrayListHome<Integer> arrayListHome = new ArrayListHome<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayListHome.add(i);
        }
        arrayListHome.clear();
        arrayListHome.print();
    }

    @Test
    void setTest() {
        ArrayListHome<String> arrayListHome = new ArrayListHome<>(5000);
        for (int i = 0; i < 5000; i++) {
            arrayListHome.add("not set");
        }
        for (int i = 0; i < 5000; i++) {
            arrayListHome.set("set", i);
        }
        arrayListHome.print();
    }

    @Test
    void trimToSizeTest() {
        ArrayListHome<Double> arrayListHome = new ArrayListHome<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayListHome.add(i * 1.0);
        }
        for (int i = 0; i < 5000; i++) {
            arrayListHome.remove(i);
        }
        arrayListHome.trimToSize();
        arrayListHome.print();
    }
}
