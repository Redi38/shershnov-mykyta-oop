package ua.khpi.oop.shershnov09.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з планувальником подій.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Planner planner = new Planner();

    public static void main(String[] args) {
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
                    saveEventsMenu();
                    break;
                case 4:
                    // Відновлення подій
                    loadEventsMenu();
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

    /**
     * Виводить на екран меню користувача.
     */
    private static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати подію");
        System.out.println("2. Переглянути всі події");
        System.out.println("3. Зберегти події");
        System.out.println("4. Відновити події");
        System.out.println("5. Вийти");
        System.out.print("Ваш вибір: ");
    }

    /**
     * Отримує вибір користувача.
     *
     * @param scanner Об'єкт Scanner для введення з консолі.
     * @return Вибір користувача.
     */
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

    /**
     * Додає нову подію до планувальника.
     *
     * @param scanner Об'єкт Scanner для введення з консолі.
     * @param planner Планувальник подій.
     */
    private static void addEvent(Scanner scanner, Planner planner) {
        System.out.println("Введіть опис події:");
        String description = scanner.nextLine();
        System.out.println("Введіть дату події (у форматі dd/MM/yyyy HH:mm):");
        String dateStr = scanner.nextLine();
        System.out.println("Введіть місце проведення події:");
        String location = scanner.nextLine();
        System.out.println("Введіть тривалість події (у годинах):");
        int duration = Integer.parseInt(scanner.nextLine());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            Event newEvent = new Event(description, date, location, duration, "optionalTime");
            planner.addEvent(newEvent);
            System.out.println("Подія додана.");
        } else {
            System.out.println("Некоректний формат дати. Подія не додана.");
        }
    }

    /**
     * Виводить на екран всі події з планувальника.
     *
     * @param planner Планувальник подій.
     */
    private static void displayAllEvents(Planner planner) {
        planner.displayEvents();
    }

    /**
     * Виводить меню для збереження подій та оброблює вибір користувача.
     */
    private static void saveEventsMenu() {
        System.out.println("Оберіть метод збереження:");
        System.out.println("1. За допомогою стандартної серіалізації");
        System.out.println("2. Без використання серіалізації");
        System.out.print("Ваш вибір: ");
        int saveChoice = Integer.parseInt(scanner.nextLine());

        switch (saveChoice) {
            case 1:
                saveEventsWithSerialization();
                break;
            case 2:
                saveEventsWithoutSerialization();
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    /**
     * Зберігає події з використанням стандартної серіалізації.
     */
    private static void saveEventsWithSerialization() {
        System.out.println("Введіть шлях до файлу для збереження:");
        String filePath = scanner.nextLine();
        DataPersistence.saveEventsWithSerialization(planner, filePath);
    }

    /**
     * Зберігає події без використання серіалізації.
     */
    private static void saveEventsWithoutSerialization() {
        System.out.println("Введіть шлях до файлу для збереження:");
        String filePath = scanner.nextLine();
        DataPersistence.saveEventsWithoutSerialization(planner, filePath);
    }

    /**
     * Виводить меню для відновлення подій та оброблює вибір користувача.
     */
    private static void loadEventsMenu() {
        System.out.println("Оберіть метод відновлення:");
        System.out.println("1. За допомогою стандартної серіалізації");
        System.out.println("2. Без використання серіалізації");
        System.out.print("Ваш вибір: ");
        int loadChoice = Integer.parseInt(scanner.nextLine());

        switch (loadChoice) {
            case 1:
                loadEventsWithSerialization();
                break;
            case 2:
                loadEventsWithoutSerialization();
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    /**
     * Відновлює події з використанням стандартної серіалізації.
     */
    private static void loadEventsWithSerialization() {
        System.out.println("Введіть шлях для відновлення подій:");
        String filePath = scanner.nextLine();
        if (DataPersistence.loadEventsWithSerialization(filePath, planner)) {
            System.out.println("Події успішно відновлені з файлу.");
        } else {
            System.out.println("Не вдалося відновити події з файлу.");
        }
    }

    /**
     * Відновлює події без використання серіалізації.
     */
    private static void loadEventsWithoutSerialization() {
        System.out.println("Введіть шлях для відновлення подій:");
        String filePath = scanner.nextLine();
        if (DataPersistence.loadEventsWithoutSerialization(filePath, planner)) {
            System.out.println("Події успішно відновлені з файлу.");
        } else {
            System.out.println("Не вдалося відновити події з файлу.");
        }
    }
}
