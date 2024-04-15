package ua.khpi.oop.shershnov15.Task;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

/**
 * Головний клас програми для роботи з планувальником подій.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Planner planner = new Planner();

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-auto")) {
            runAutomaticMode();
        } else {
            runInteractiveMode();
        }
    }
    
    /**
     * Метод для запуску інтерактивного режиму виконання програми.
     */
    private static void runInteractiveMode() {
        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addEvent(scanner, planner);
                    break;
                case 2:
                    displayAllEvents(planner);
                    break;
                case 3:
                    deleteEvent(scanner, planner);
                    break;
                case 4:
                    saveEventsMenu();
                    break;
                case 5:
                    loadEventsMenu();
                    break;
                case 6:
                    sortEventsByDate(planner);
                case 7:
                    sortEventsByDuration(planner);
                    break;
                case 8:
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
     * Метод для відображення головного меню програми.
     */
    private static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати подію");
        System.out.println("2. Переглянути всі події");
        System.out.println("3. Видалити подію");
        System.out.println("4. Зберегти події");
        System.out.println("5. Відновити події");
        System.out.println("6. Обчислити загальну тривалість всіх подій");
        System.out.println("7. Підрахувати кількість подій з тривалістю більше 24 годин");
        System.out.println("8. Вийти");
        System.out.print("Ваш вибір: ");
    }

    
    /**
     * Метод для отримання вибору користувача з меню.
     * 
     * @param scanner Об'єкт Scanner для зчитування введених даних.
     * @return Вибраний користувачем пункт меню.
     */
    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 8) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Введіть число від 1 до 6.");
            }
        }
        return choice;
    }
    
    /**
     * Метод для додавання події до планувальника.
     * 
     * @param scanner Об'єкт Scanner для зчитування введених даних.
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

        // Валідація дати за допомогою регулярного виразу
        if (!isValidDateFormat(dateStr)) {
            System.out.println("Некоректний формат дати. Подія не додана.");
            return;
        }

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
     * Видаляє подію з планувальника за вказаним індексом.
     *
     * @param scanner об'єкт Scanner для отримання введення користувача з консолі.
     * @param planner планувальник, з якого видаляється подія.
     */
    private static void deleteEvent(Scanner scanner, Planner planner) {
        System.out.print("Введіть індекс події для видалення: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера вводу

        if (index >= 0 && index < planner.size()) {
            Event deletedEvent = planner.removeEvent(index);
            System.out.println("Подія успішно видалена: " + deletedEvent);
        } else {
            System.out.println("Некоректний індекс. Подія не була видалена.");
        }
    }
    
    /**
     * Метод для перевірки коректності формату дати за допомогою регулярних виразів.
     * 
     * @param dateStr Рядок, що представляє дату.
     * @return true, якщо формат дати коректний, false - в іншому випадку.
     */
    private static boolean isValidDateFormat(String dateStr) {
        String regex = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}";
        return dateStr.matches(regex);
    }
    
    /**
     * Метод для відображення всіх подій з планувальника.
     * 
     * @param planner Планувальник подій.
     */
    private static void displayAllEvents(Planner planner) {
        planner.displayEvents();
    }
    
    /**
     * Сортує події в планувальнику за датою та виводить відсортований список подій.
     *
     * @param planner Планувальник подій, що містить події для сортування та виведення.
     */
    private static void sortEventsByDate(Planner planner) {
        // Сортуємо події за датою
        planner.sortByDate();
        System.out.println("Події були відсортовані за датою:");
        planner.displayEvents();
    }    

	/**
	 * Сортує події в планувальнику за датою та виводить відсортований список подій.
	 *
	 * @param planner Планувальник подій, що містить події для сортування та виведення.
	 */
	private static void sortEventsByDuration(Planner planner) {
	    // Сортуємо події за тривалістю
	    planner.sortByDuration();
	    System.out.println("Події були відсортовані за датою:");
	    planner.displayEvents();
	}
    
    /**
     * Метод для збереження подій.
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
     * Метод для збереження подій за допомогою стандартної серіалізації.
     */
    private static void saveEventsWithSerialization() {
        System.out.println("Введіть шлях до файлу для збереження:");
        String filePath = scanner.nextLine();
        DataPersistence.saveEventsWithSerialization(planner, filePath);
    }
    
    /**
     * Метод для збереження подій без використання серіалізації.
     */
    private static void saveEventsWithoutSerialization() {
        System.out.println("Введіть шлях до файлу для збереження:");
        String filePath = scanner.nextLine();
        DataPersistence.saveEventsWithoutSerialization(planner, filePath);
    }

    /**
     * Метод для відновлення подій.
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
     * Метод для відновлення подій за допомогою стандартної серіалізації.
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
     * Метод для відновлення подій без допомоги стандартної серіалізації.
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
    
    /**
     * Метод для запуску автоматичного режиму виконання програми.
     */
    private static void runAutomaticMode() {
        String filePath = "input.txt"; // Шлях до текстового файлу з даними

     // Зчитування подій з файлу input.txt
        try (Scanner fileScanner = new Scanner(new File("input.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String description = parts[0];
                    String dateStr = parts[1];
                    String location = parts[2];
                    int duration = Integer.parseInt(parts[3].trim());

                    // Валідація дати за допомогою регулярного виразу
                    if (!isValidDateFormat(dateStr)) {
                        System.out.println("Некоректний формат дати. Подія не додана.");
                        continue;
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = dateFormat.parse(dateStr);

                    Event event = new Event(description, date, location, duration, "");
                    planner.addEvent(event);
                }
            }
        } catch (FileNotFoundException | ParseException e) {
            System.out.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }
        sortEventsByDate (planner);
        sortEventsByDuration(planner);
    }    
}
