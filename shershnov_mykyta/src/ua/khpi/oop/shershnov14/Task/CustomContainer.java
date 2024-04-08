package ua.khpi.oop.shershnov14.Task;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Клас-контейнер для зберігання domain-об'єктів планувальника.
 * @param <T> Тип об'єктів, які зберігає контейнер.
 */
public class CustomContainer<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 1L;

    private Node<T> head;
    private int size;

    /**
     * Конструктор для створення порожнього контейнера.
     */
    public CustomContainer() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Додає елемент до контейнера.
     *
     * @param element Елемент для додавання.
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Видаляє елемент з контейнера.
     *
     * @param element Елемент для видалення.
     * @return true, якщо елемент видалено, false - якщо елемент не знайдено.
     */
    public boolean remove(T element) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.getData().equals(element)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    /**
     * Очищує контейнер від усіх елементів.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Перетворює контейнер у масив.
     *
     * @return Масив елементів контейнера.
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<T> current = head;

        while (current != null) {
            array[index++] = current.getData();
            current = current.getNext();
        }

        return array;
    }

    /**
     * Перетворює контейнер у рядок.
     *
     * @return Рядок, що представляє контейнер.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }

        result.append("]");
        return result.toString();
    }

    /**
     * Перевіряє, чи містить контейнер заданий елемент.
     *
     * @param element Елемент для перевірки.
     * @return true, якщо елемент міститься в контейнері, false - в іншому випадку.
     */
    public boolean contains(T element) {
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Повертає розмір контейнера.
     *
     * @return Розмір контейнера.
     */
    public int size() {
        return size;
    }

    /**
     * Повертає ітератор для циклу foreach.
     *
     * @return Ітератор контейнера.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    /**
     * Внутрішній клас, що представляє вузол зв'язаного списку.
     *
     * @param <E> Тип даних вузла.
     */
    private static class Node<E> implements Serializable {
        private static final long serialVersionUID = 1L;

        private E data;
        private Node<E> next;

        /**
         * Конструктор для створення вузла з заданим елементом.
         *
         * @param data Елемент вузла.
         */
        Node(E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Повертає дані вузла.
         *
         * @return Дані вузла.
         */
        E getData() {
            return data;
        }

        /**
         * Повертає наступний вузол у списку.
         *
         * @return Наступний вузол у списку.
         */
        Node<E> getNext() {
            return next;
        }

        /**
         * Встановлює наступний вузол у списку.
         *
         * @param next Новий наступний вузол.
         */
        void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
