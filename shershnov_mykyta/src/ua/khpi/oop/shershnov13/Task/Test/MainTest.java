package ua.khpi.oop.shershnov13.Task.Test;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.shershnov13.Task.Main;
import ua.khpi.oop.shershnov13.Task.Planner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Клас, що містить тести для перевірки методів класу Main.
 */
public class MainTest {

    /**
     * Тест для перевірки коректності формату дати.
     * Перевіряється випадок коректного формату дати.
     */
    @Test
    public void testIsValidDateFormat_ValidFormat() {
        assertTrue(Main.isValidDateFormat("12/04/2024 15:30"));
    }

    /**
     * Тест для перевірки коректності формату дати.
     * Перевіряється випадок некоректного формату дати.
     */
    @Test
    public void testIsValidDateFormat_InvalidFormat() {
        assertFalse(Main.isValidDateFormat("2024-04-12 15:30"));
    }

    /**
     * Тест для перевірки додавання події до планувальника.
     * Перевіряється випадок додавання події з коректними даними.
     */
    @Test
    public void testAddEvent_ValidInput() {
        String input = "Event description\n12/04/2024 15:30\nLocation\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();
        Main.addEvent(scanner, planner);
        assertTrue(planner.getAllEvents().length == 1);
    }

    /**
     * Тест для перевірки додавання події до планувальника.
     * Перевіряється випадок додавання події з некоректним форматом дати.
     */
    @Test
    public void testAddEvent_InvalidDateFormat() {
        String input = "Event description\n2024-04-12 15:30\nLocation\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();
        Main.addEvent(scanner, planner);
        assertTrue(planner.getAllEvents().length == 0);
    }
}
