package ua.khpi.oop.shershnov05.Task;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Клас-контейнер для збереження та опрацювання рядків.
 */
public class Container implements Iterable<String> {
    private String[] data;
    private int size;

    /**
     * Конструктор без параметрів, створює об'єкт класу Container.
     */
    public Container() {
        data = new String[10];
        size = 0;
    }

    /**
     * Перетворює контейнер на рядок.
     *
     * @return Рядок, що містить вміст контейнера.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return "[" + result.toString() + "]";
    }

    /**
     * Додає рядок до контейнера.
     *
     * @param string Рядок, який потрібно додати до контейнера.
     */
    public void add(String string) {
        if (size == data.length) {
            // Розширюємо масив, якщо він повний
            String[] newData = new String[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = string;
        size++;
    }

    /**
     * Очищає контейнер.
     */
    public void clear() {
        data = new String[10];
        size = 0;
    }

    /**
     * Видаляє перший випадок вказаного рядка з контейнера.
     *
     * @param string Рядок, який потрібно видалити з контейнера.
     * @return true, якщо рядок був успішно видалений, false - інакше.
     */
    public boolean remove(String string) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(string)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[size - 1] = null; // Видаляємо посилання на останній елемент
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Перетворює контейнер на масив об'єктів.
     *
     * @return Масив об'єктів, що містить всі елементи контейнера.
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(data, 0, array, 0, size);
        return array;
    }

    /**
     * Повертає кількість елементів у контейнері.
     *
     * @return Кількість елементів у контейнері.
     */
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи містить контейнер вказаний рядок.
     *
     * @param string Рядок, який перевіряється на наявність у контейнері.
     * @return true, якщо рядок міститься у контейнері, false - інакше.
     */
    public boolean contains(String string) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє, чи містить контейнер всі рядки з іншого контейнера.
     *
     * @param container Інший контейнер, рядки якого перевіряються на наявність у поточному контейнері.
     * @return true, якщо всі рядки з іншого контейнера містяться у поточному контейнері, false - інакше.
     */
    public boolean containsAll(Container container) {
        for (int i = 0; i < container.size; i++) {
            if (!contains(container.data[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Повертає ітератор для перебору рядків у контейнері.
     *
     * @return Ітератор для перебору рядків.
     */
    public Iterator<String> iterator() {
        return new ContainerIterator();
    }

    private class ContainerIterator implements Iterator<String> {
        private int currentIndex = 0;

        /**
         * Перевіряє наявність наступного елемента для ітерації.
         *
         * @return true, якщо існує наступний елемент, false - інакше.
         */
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Повертає наступний елемент при ітерації.
         *
         * @return Наступний рядок у контейнері.
         */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[currentIndex++];
        }

        /**
         * Видаляє елемент під час ітерації. Операція видалення не підтримується і генерує UnsupportedOperationException.
         */
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
