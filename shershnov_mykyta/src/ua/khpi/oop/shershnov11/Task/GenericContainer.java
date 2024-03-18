package ua.khpi.oop.shershnov11.Task;

import java.util.Arrays;

/**
 * Клас-контейнер для зберігання об'єктів будь-якого типу.
 * @param <T> Тип об'єктів, які зберігаються в контейнері.
 */
public class GenericContainer<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор за замовчуванням, який створює контейнер з початковою ємністю 10.
     */
    public GenericContainer() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Додає елемент до контейнера.
     * @param element Елемент, який потрібно додати.
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Повертає елемент за індексом.
     * @param index Індекс елемента.
     * @return Елемент за заданим індексом.
     * @throws IndexOutOfBoundsException Якщо індекс виходить за межі діапазону.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Повертає кількість елементів в контейнері.
     * @return Кількість елементів.
     */
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи необхідно збільшити ємність контейнера, і збільшує її, якщо потрібно.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
}
