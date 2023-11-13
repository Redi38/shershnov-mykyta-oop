package ua.khpi.oop.shershnov08.Task;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з планувальником подій.
 */
public class Main {
    Scanner scanner = new Scanner(System.in);
    Planner planner = new Planner();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();

        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Додавання події
                    addEvent(scanner, planner);
                    break;
                case 2:
                    // Виведення всіх подій
                    displayAllEvents(planner);
                    break;
                case 3:
                    // Збереження подій
                    System.out.println("Введіть шлях до файлу для збереження:");
                    String filePath = scanner.nextLine();
                    saveEvents(planner, filePath);
                    break;
                case 4:
                    // Відновлення подій
                    loadEvents(scanner, planner);
                    break;
                case 5:
                    // Завершення програми
                    System.out.println("Дякуємо за використання планувальника!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати подію");
        System.out.println("2. Переглянути всі події");
        System.out.println("3. Зберегти події");
        System.out.println("4. Відновити події");
        System.out.println("5. Вийти");
        System.out.print("Ваш вибір: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Введіть число від 1 до 5.");
            }
        }
        return choice;
    }

    private static void addEvent(Scanner scanner, Planner planner) {
        System.out.println("Введіть опис події:");
        String description = scanner.nextLine();
        System.out.println("Введіть дату події (у форматі dd/MM/yyyy HH:mm):");
        String dateStr = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Некоректний формат дати. Введіть дату у форматі dd/MM/yyyy HH:mm.");
            return;
        }
        System.out.println("Введіть місце проведення події:");
        String location = scanner.nextLine();
        System.out.println("Введіть тривалість події (у хвилинах):");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть час події (у хвилинах після півночі):");
        String time = scanner.nextLine();

        Event newEvent = new Event(description, date, location, duration, time);
        planner.addEvent(newEvent);
        System.out.println("Подія додана.");
    }

    private static void displayAllEvents(Planner planner) {
        System.out.println("Список всіх подій у планувальнику:");
        Event[] events = planner.getAllEvents();
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private static void saveEvents(Planner planner, String filePath) {
        DataPersistence.saveEvents(Arrays.asList(planner.getAllEvents()), filePath);
    }

    private static void loadEvents(Scanner scanner, Planner planner) {
        System.out.println("Введіть шлях для відновлення подій:");
        String filePath = scanner.nextLine();

        List<Event> loadedEvents = DataPersistence.loadEvents(filePath);

        if (loadedEvents != null) {
            Event[] eventsArray = loadedEvents.toArray(new Event[0]);
            planner.setEvents(eventsArray);
            System.out.println("Події успішно відновлені з файлу.");
        } else {
            System.out.println("Не вдалося відновити події з файлу.");
        }
    }
}

