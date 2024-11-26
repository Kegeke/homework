package org.example.homework1.collection;

import java.util.Comparator;

interface ListCollection<E> {
    void add(E obj);

    void add(int index, E obj);

    E get(int index);

    E remove(int index);

    void clear();

    void sort(Comparator<? super E> comparator);

    E set(E obj, int index);
}
