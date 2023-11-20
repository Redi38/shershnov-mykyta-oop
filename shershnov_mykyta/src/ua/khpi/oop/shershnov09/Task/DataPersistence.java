package ua.khpi.oop.shershnov09.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для збереження та відновлення об'єктів планувальника.
 */
public class DataPersistence {
    /**
     * Зберегти події планувальника в файл за допомогою стандартної серіалізації.
     *
     * @param planner   Планувальник з подіями.
     * @param filePath Шлях до файлу для збереження.
     */
    public static void saveEventsWithSerialization(Planner planner, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(planner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Зберегти події планувальника в файл без використання серіалізації.
     *
     * @param planner   Планувальник з подіями.
     * @param filePath Шлях до файлу для збереження.
     */
    public static void saveEventsWithoutSerialization(Planner planner, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Event event : planner.getAllEvents()) {
                writer.write(event.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити події планувальника з файлу за допомогою стандартної серіалізації.
     *
     * @param filePath Шлях до файлу для завантаження.
     * @param planner  Планувальник для збереження завантажених подій.
     * @return true, якщо завантаження пройшло успішно, false - в іншому випадку.
     */
    public static boolean loadEventsWithSerialization(String filePath, Planner planner) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Planner loadedPlanner = (Planner) ois.readObject();
            planner.setEvents(loadedPlanner.getAllEvents());
            return true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Завантажити події планувальника з файлу без використання серіалізації.
     *
     * @param filePath Шлях до файлу для завантаження.
     * @param planner  Планувальник для збереження завантажених подій.
     * @return true, якщо завантаження пройшло успішно, false - в іншому випадку.
     */
    public static boolean loadEventsWithoutSerialization(String filePath, Planner planner) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Event event = Event.fromFileString(line);
                if (event != null) {
                    events.add(event);
                }
            }
            planner.setEvents(events.toArray(new Event[0]));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
