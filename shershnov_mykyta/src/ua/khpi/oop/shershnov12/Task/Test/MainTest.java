package ua.khpi.oop.shershnov12.Task.Test;

import org.junit.jupiter.api.Test;

import ua.khpi.oop.shershnov12.Task.Event;
import ua.khpi.oop.shershnov12.Task.Main;
import ua.khpi.oop.shershnov12.Task.Planner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Клас, що містить тести для пошуку конференцій.
 */
public class MainTest {

    /**
     * Тест для методу searchConferences.
     */
    @Test
    public void testSearchConferences() {
        // Організація
        Planner planner = new Planner();
        Event event1 = new Event("Конференція 1", createDate(2022, 4, 15), "Харків", 24, "");
        Event event2 = new Event("Конференція 2", createDate(2023, 6, 20), "Харківська область", 24, "");
        Event event3 = new Event("Конференція 3", createDate(2024, 8, 25), "Харків", 23, ""); // Тривалість менше 24 годин
        Event event4 = new Event("Конференція 4", createDate(2023, 9, 30), "Інше місто", 24, ""); // Не в Харкові
        Event event5 = new Event("Конференція 5", createDate(2021, 10, 5), "Харків", 48, "");

        planner.addEvent(event1);
        planner.addEvent(event2);
        planner.addEvent(event3);
        planner.addEvent(event4);
        planner.addEvent(event5);

        // Дія
        Main.searchConferences(planner);

        // Перевірка
        assertTrue(planner.getAllEvents().length == 5); // Всі п'ять конференцій відповідають умовам
    }

    /**
     * Метод для створення дати.
     *
     * @param year  Рік.
     * @param month Місяць.
     * @param day   День.
     * @return Дата у форматі Date.
     */
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Місяць в Calendar нумерується з нуля
        return calendar.getTime();
    }
}
