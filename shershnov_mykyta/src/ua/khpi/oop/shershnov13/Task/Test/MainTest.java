package ua.khpi.oop.shershnov13.Task.Test;

import org.junit.jupiter.api.Test;

import ua.khpi.oop.shershnov13.Task.Main;
import ua.khpi.oop.shershnov13.Task.Planner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testIsValidDateFormat_ValidFormat() {
        assertTrue(Main.isValidDateFormat("12/04/2024 15:30"));
    }

    @Test
    public void testIsValidDateFormat_InvalidFormat() {
        assertFalse(Main.isValidDateFormat("2024-04-12 15:30"));
    }

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
