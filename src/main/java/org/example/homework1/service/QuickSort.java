package org.example.homework1.service;

import org.example.homework1.collection.ArrayListHome;

import java.util.Comparator;

public class QuickSort {
    private QuickSort() {
        throw new RuntimeException();
    }

    /*
    Сортировка по особому порядку
     */
    public static <E> void sort(ArrayListHome<E> list, Comparator<E> com) {
        quickSort(list, 0, list.size() - 1, com);
    }

    private static <E> void quickSort(ArrayListHome<E> list, int left, int right, Comparator<? super E> comparator) {
        if (left < right) {
            int pivot = findPivot(list, left, right, comparator);

            quickSort(list, left, pivot, comparator);
            quickSort(list, pivot + 1, right, comparator);
        }
    }

    private static <E> int findPivot(ArrayListHome<E> list, int left, int right, Comparator<? super E> comparator) {
        E pivot = list.get((left + right) / 2);

        while (left <= right) {
            while (comparator.compare(list.get((left)), pivot) <= 0) {
                left++;
            }

            while (comparator.compare(list.get((right)), pivot) > 0) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(list, left++, right--);
        }

        return right;
    }

    private static <E> void swap(ArrayListHome<E> list, int left, int right) {
        E temp = list.get(left);
        list.set(list.get(right), left);
        list.set(temp, right);
    }

    /*
    Сортировка по естественному порядку
     */
    public static <E extends Comparable<E>> void sort(ArrayListHome<E> list) {
        quickSortSecond(list, 0, list.size() - 1);
    }

    private static <E extends Comparable<E>> void quickSortSecond(ArrayListHome<E> list, int left, int right) {
        if (left < right) {
            int pivot = findPivot(list, left, right);

            quickSortSecond(list, left, pivot);
            quickSortSecond(list, pivot + 1, right);
        }
    }

    private static <E extends Comparable<E>> int findPivot(ArrayListHome<E> list, int left, int right) {
        E pivot = list.get((left + right) / 2);

        while (left <= right) {
            while (list.get(left).compareTo(pivot) < 0) {
                left++;
            }

            while (list.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(list, left++, right--);
        }

        return right;
    }
}




