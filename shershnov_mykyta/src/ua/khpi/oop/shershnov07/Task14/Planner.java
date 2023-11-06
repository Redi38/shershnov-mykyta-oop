package ua.khpi.oop.shershnov07.Task14;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Клас, що представляє планувальник з подіями.
 */
public class Planner {
    private List<Event> events; // Список подій

    /**
     * Конструктор для створення нового планувальника.
     */
    public Planner() {
        events = new ArrayList<>();
    }

    /**
     * Додає подію до планувальника.
     *
     * @param event Подія, яку додаємо до планувальника.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Видаляє подію з планувальника.
     *
     * @param event Подія, яку видаляємо з планувальника.
     */
    public void removeEvent(Event event) {
        events.remove(event);
    }

    /**
     * Редагує подію в планувальнику.
     *
     * @param event Подія, яку редагуємо.
     * @param newDescription Новий опис події.
     * @param newDate Нова дата події.
     * @param newLocation Нове місце проведення події.
     */
    public void editEvent(Event event, String newDescription, Date newDate, String newLocation) {
        // Логіка для редагування події
    }

    /**
     * Виводить всі події із планувальника.
     */
    public void displayEvents() {
        for (Event event : events) {
            System.out.println(event.toString());
        }
    }

    /**
     * Повертає всі події із планувальника у вигляді масиву.
     *
     * @return Масив подій.
     */
    public Event[] getAllEvents() {
        Event[] eventArray = new Event[events.size()];
        events.toArray(eventArray);
        return eventArray;
    }
}
