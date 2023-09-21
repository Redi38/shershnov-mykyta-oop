package ua.khpi.oop.shershnov02.Task4;

import java.util.Random;

/**
 * Програма для пошуку позиції та значення найменшої цифри в десятковому запису цілих чисел.
 */
public class Main {
    private static final int NUM_ITERATIONS = 10;

    /**
     * Точка входу в програму.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Число | Мінімальна цифра | Позиція мінімальної цифри");

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int number = random.nextInt(1000);
            findMinDigitInfoAndPrint(number);
        }
    }

    /**
     * Метод для знаходження мінімальної цифри та її позиції у числі і виведення результатів.
     *
     * @param number Ціле число, для якого потрібно знайти мінімальну цифру та її позицію.
     */
    private static void findMinDigitInfoAndPrint(int number) {
        int minDigit = 9;
        int minPosition = -1;
        int currentPosition = 0;
        int numCopy = number;
        int position = 0;

        while (numCopy > 0) {
            int digit = numCopy % 10;
            numCopy /= 10;
            currentPosition++;

            if (digit < minDigit) {
                minDigit = digit;
                minPosition = currentPosition;
            } else if (digit == minDigit && minPosition == -1) {
                minPosition = position;
            }
            position++;
        }

        System.out.printf("%5d | %17d | %21d%n", number, minDigit, position - minPosition + 1);
    }
}




















