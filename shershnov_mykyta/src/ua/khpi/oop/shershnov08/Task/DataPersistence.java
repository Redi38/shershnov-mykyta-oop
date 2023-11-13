package ua.khpi.oop.shershnov08.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для збереження та відновлення об'єктів планувальника.
 */
public class DataPersistence {

    /**
     * Зберегти події планувальника в файл.
     *
     * @param events   Масив подій для збереження
     * @param filePath Шлях до файлу для збереження
     */
    public static void saveEvents(List<Event> events, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Event event : events) {
                writer.write(event.toFileString()); // Assuming you have implemented toFileString() method in Event class
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити події планувальника з файлу.
     *
     * @param filePath Шлях до файлу для завантаження
     * @return Масив подій, якщо завантаження пройшло успішно, null - в іншому випадку
     */
    public static List<Event> loadEvents(String filePath) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Event event = Event.fromFileString(line); // Assuming you have implemented a static method in Event class to create an event from file string
                if (event != null) {
                    events.add(event);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
