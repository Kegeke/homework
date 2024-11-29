package org.example.homework1.service;

import org.example.homework1.collection.ArrayListHome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class QuickSortTest {
    @Test
    void sortTest() {
        ArrayListHome<String> arrayListHome = new ArrayListHome<>();
        arrayListHome.add("Ada");
        arrayListHome.add("Daddy");
        arrayListHome.add("Kiki");
        arrayListHome.add("Baby");
        arrayListHome.add("Nicolas");
        QuickSort.sort(arrayListHome);

        String[] expectedString = {"Ada", "Baby", "Daddy", "Kiki", "Nicolas"};

        Assertions.assertEquals(Arrays.toString(expectedString), Arrays.toString(arrayListHome.getArray()));
    }

    @Test
    void sortComparatorTest() {
        ArrayListHome<Integer> arrayListHome = new ArrayListHome<>();
        arrayListHome.add(22);
        arrayListHome.add(7);
        arrayListHome.add(-1);
        arrayListHome.add(19);
        arrayListHome.add(20);
        arrayListHome.add(2);
        QuickSort.sort(arrayListHome, Comparator.naturalOrder());

        int[] expectedInt = {-1, 2, 7, 19, 20, 22};

        Assertions.assertEquals(Arrays.toString(expectedInt), Arrays.toString(arrayListHome.getArray()));
    }
}