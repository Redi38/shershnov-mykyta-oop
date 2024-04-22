package ua.khpi.oop.shershnov09.Task;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Клас, що представляє планувальник з подіями.
 */
public class Planner implements Iterable<Event>, Serializable {
	private static final long serialVersionUID = 1L;

    private List<Event> events; // Список подій

    /**
     * Конструктор для створення нового планувальника.
     */
    public Planner() {
        events = new LinkedList<>();
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
     * Виводить всі події із планувальника.
     */
    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("Планувальник порожній.");
        } else {
            System.out.println("Список всіх подій у планувальнику:");
            for (Event event : events) {
                System.out.println(event);
            }
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

    /**
     * Встановлює список подій планувальника.
     *
     * @param events Масив подій.
     */
    public void setEvents(Event[] events) {
        this.events = Arrays.asList(events);
    }
    
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
