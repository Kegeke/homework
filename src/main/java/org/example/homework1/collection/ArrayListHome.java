package org.example.homework1.collection;

import java.util.Arrays;

/*
 * Собственнвеная реализация коллекции ArrayList<E>
 *
 */
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

    /*
     * Добавление элемента в конец масива
     * Если массив полон, увеличиваем размер его размер
     */
    @Override
    public void add(E e) {
        if (size == elements.length) {
            grow(size + 1);
        }
        elements[size] = e;
        size++;
    }

    /*
     * Добавление элемента в массив по индексу, при этом
     * элементы сдвигаются вправо на 1
     * Выбрасывается исключение, если индекс вне диапазона массива -
     * IndexOutOfBoundsException
     *
     * @param - индекс куда вставляется элемент
     *        - элемент вставляемый в массив
     */
    @Override
    public void add(int index, E e) {
        checkIndex(index);

        if (size == elements.length) {
            grow(size + 1);
        }

        Object[] elem = new Object[elements.length];

        if (index >= 0) System.arraycopy(elements, 0, elem, 0, index);

        elem[index] = e;

        if (elements.length - (index + 1) >= 0)
            System.arraycopy(elements, index + 1 - 1, elem, index + 1, elements.length - (index + 1));

        size++;
        elements = elem;
    }

    /*
     * Получить элемент массива по индексу
     * Выбрасывается исключение, если индекс вне диапазона массива -
     * IndexOutOfBoundsException
     *
     * @param индекс элемента в массиве
     * @return возврат элемента по индекс
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);

        return (E) elements[index];
    }

    /*
     * Удалить элемент по индексу
     * Элемены сдвигаются на один элемент влево
     * Выбрасывается исключение, если индекс вне диапазона массива -
     * IndexOutOfBoundsException
     *
     * @param - индекс элемента в массиве
     * @return возврат удаленного элемента
     */
    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        checkIndex(index);

        E oldElem = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;

        return oldElem;
    }

    /*
     * Очистка массива
     * Свободные ячейки заполнятся null
     */
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    /*
     * Замена элемента по индексу входящим елементом
     *
     * @param - индекс элемента в массиве
     *        - заменяемый элемент
     * @return возврат удаленного элемента
     */
    @SuppressWarnings("unchecked")
    @Override
    public E set(E e, int index) {
        checkIndex(index);

        E oldElement = (E) elements[index];
        elements[index] = e;
        return oldElement;
    }

    /*
     * Обрезает текущию емкость массива до текущего
     * размера массива
     */
    public void trimToSize() {
        Object[] elem = new Object[size];
        copy(elem);
    }

    /*
     * @return возврат размера массива
     */
    public int size() {
        return size;
    }

    /*
     * @return возврат массива объектов
     */
    public Object[] getArray() {
        return Arrays.copyOf(elements, size);
    }

    /*
     * Вывести в консоль текущий массив элементов
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i] + ";");
        }
    }

    private void grow(int size) {
        int newCapacity = (size * 3) / 2 + 1;

        Object[] elem = new Object[newCapacity];
        copy(elem);

        elements = elem;
    }

    private void copy(Object[] objects) {
        if (size >= 0) System.arraycopy(elements, 0, objects, 0, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
