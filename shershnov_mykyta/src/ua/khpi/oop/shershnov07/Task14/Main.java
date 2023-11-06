package ua.khpi.oop.shershnov07.Task14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з планувальником подій.
 */
public class Main {
    /**
     * Головний метод програми.
     * 
     * @param args Параметри командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();

        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Додавання події
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
                        continue;
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
                    break;
                case 2:
                    // Виведення всіх подій
                    System.out.println("Список всіх подій у планувальнику:");
                    Event[] events = planner.getAllEvents();
                    for (Event event : events) {
                        System.out.println(event);
                    }
                    break;
                case 3:
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
     * Виводить на екран меню вибору опцій.
     */
    private static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати подію");
        System.out.println("2. Переглянути всі події");
        System.out.println("3. Вийти");
        System.out.print("Ваш вибір: ");
    }

    /**
     * Отримує вибір користувача та повертає його.
     * 
     * @param scanner Об'єкт Scanner для введення даних користувачем.
     * @return Вибір користувача.
     */
    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 3) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Введіть число від 1 до 3.");
            }
        }
        return choice;
    }
}
