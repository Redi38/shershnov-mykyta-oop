package ua.khpi.oop.shershnov09.Task.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.khpi.oop.shershnov09.Task.CustomContainer;

import java.util.Iterator;

@DisplayName("Тести для CustomContainer")
class CustomContainerTest {

    private CustomContainer<Integer> container;

    @BeforeEach
    void setUp() {
        container = new CustomContainer<>();
    }

    @Test
    @DisplayName("Тест методу add")
    void testAdd() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(3, container.size());
        assertTrue(container.contains(2));
        assertFalse(container.contains(5));
    }

    @Test
    @DisplayName("Тест методу remove")
    void testRemove() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertTrue(container.remove(2));
        assertFalse(container.remove(5));
        assertEquals(2, container.size());
    }

    @Test
    @DisplayName("Тест методу clear")
    void testClear() {
        container.add(1);
        container.add(2);

        container.clear();

        assertEquals(0, container.size());
        assertFalse(container.contains(1));
    }

    @Test
    @DisplayName("Тест методу toArray")
    void testToArray() {
        container.add(1);
        container.add(2);
        container.add(3);

        Object[] array = container.toArray();

        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    @DisplayName("Тест методу contains")
    void testContains() {
        container.add(1);
        container.add(2);

        assertTrue(container.contains(2));
        assertFalse(container.contains(3));
    }

    @Test
    @DisplayName("Тест методу size")
    void testSize() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(3, container.size());
    }

    @Test
    @DisplayName("Тест методу iterator")
    void testIterator() {
        container.add(1);
        container.add(2);
        container.add(3);

        Iterator<Integer> iterator = container.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
