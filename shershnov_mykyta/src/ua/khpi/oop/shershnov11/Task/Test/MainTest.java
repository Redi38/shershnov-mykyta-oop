package ua.khpi.oop.shershnov11.Task.Test;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.shershnov11.Task.Main;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас, який містить тести для перевірки методів класу Main.
 */
public class MainTest {

    /**
     * Тест для перевірки методу isValidDateFormat з валідною датою.
     */
    @Test
    public void testIsValidDateFormat_ValidFormat() {
        // Arrange
        String validDate = "12/04/2024 15:30";

        // Act
        boolean isValid = Main.isValidDateFormat(validDate);

        // Assert
        assertTrue(isValid);
    }

    /**
     * Тест для перевірки методу isValidDateFormat з невалідною датою.
     */
    @Test
    public void testIsValidDateFormat_InvalidFormat() {
        // Arrange
        String invalidDate = "2024-04-12 15:30"; // Invalid format

        // Act
        boolean isValid = Main.isValidDateFormat(invalidDate);

        // Assert
        assertFalse(isValid);
    }
}
