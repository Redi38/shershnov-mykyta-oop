package ua.khpi.oop.shershnov04.Task;

import java.util.Scanner;

/**
 * Головний клас програми для введення тексту та виведення результату обробки.
 */
public class Main {
    /**
     * Головний метод програми.
     * 
     * @param args Параметри командного рядка.
     */
    public static void main(String[] args) {
        boolean debugMode = false;
        for (String arg : args) {
            if (arg.equals("-d") || arg.equals("-debug")) {
                debugMode = true;
            } else if (arg.equals("-h") || arg.equals("-help")) {
                displayProgramInfo();
                return;
            }
        }

        if (args.length > 0) {
            for (String arg : args) {
                if (arg.equals("-h") || arg.equals("-help")) {
                    displayProgramInfo(); // Вивести інформацію про програму
                    return; // Вихід з програми після виведення інформації
                } else if (arg.equals("-d") || arg.equals("-debug")) {
                    debugMode = true;
                }
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        TextProcessor textProcessor = new TextProcessor();

        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Введіть текст:");
                    String inputText = scanner.nextLine();
                    textProcessor.setInputText(inputText);
                    break;
                case 2:
                    System.out.println("Введіть символ, яким закінчуються слова:");
                    char endingChar = scanner.nextLine().charAt(0);
                    textProcessor.setEndingChar(endingChar);
                    break;
                case 3:
                    System.out.println("Введіть рядок, який потрібно вставити після кожного слова:");
                    String insertString = scanner.nextLine();
                    textProcessor.setInsertString(insertString);
                    break;
                case 4:
                    String resultText = textProcessor.processText();
                    System.out.println("Результат обробки:");
                    System.out.println(resultText);
                    break;
                case 5:
                    System.out.println("Додаткові дані для режиму налагодження:");
                    displayHelp();
                    break;
                case 6:
                    System.out.println("Дякуємо за використання програми!");
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
        System.out.println("1. Введення тексту");
        System.out.println("2. Введення символу, яким закінчуються слова");
        System.out.println("3. Введення рядка для вставки");
        System.out.println("4. Виконати обробку тексту");
        System.out.println("5. Додаткові дані для режиму налагодження");
        System.out.println("6. Завершити програму");
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
        while (choice < 1 || choice > 6) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Введіть число від 1 до 6.");
            }
        }
        return choice;
    }

    /**
     * Виводить на екран довідку.
     */
    private static void displayHelp() {
        System.out.println("Довідка:");
        System.out.println("-h або -help: Виводить інформацію про програму.");
        System.out.println("-d або -debug: Ввімкнути режим налагодження з додатковими даними.");
    }

    /**
     * Виводить інформацію про програму.
     */
    public static void displayProgramInfo() {
        System.out.println("Користувачем вводиться текст. Після кожного слова тексту, що закінчується заданим символом, вставляється зазначений рядок.");
        System.out.println("Виводиться початковий текст та результат.");
    }
}
