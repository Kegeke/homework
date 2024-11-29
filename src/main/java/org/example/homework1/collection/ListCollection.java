package org.example.homework1.collection;

/*
 * Интерфейс содержащий основные методы коллекции,
 * которые необходимо реализовать
 */
interface ListCollection<E> {
    void add(E obj);

    void add(int index, E obj);

    E get(int index);

    E remove(int index);

    void clear();

    E set(E obj, int index);
}
