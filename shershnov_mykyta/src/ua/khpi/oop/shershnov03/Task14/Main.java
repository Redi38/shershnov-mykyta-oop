package ua.khpi.oop.shershnov03.Task14;

import java.util.Scanner;

/**
 * Головний клас програми для введення тексту та виведення результату обробки.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();

        System.out.println("Введіть символ, яким закінчуються слова:");
        char endingChar = scanner.nextLine().charAt(0);

        System.out.println("Введіть рядок, який потрібно вставити після кожного слова:");
        String insertString = scanner.nextLine();

        String resultText = TextProcessor.processText(inputText, endingChar, insertString);

        System.out.println("Початковий текст:");
        System.out.println(inputText);

        System.out.println("Результат:");
        System.out.println(resultText);

        scanner.close();
    }
}

