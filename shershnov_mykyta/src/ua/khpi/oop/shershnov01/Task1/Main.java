package ua.khpi.oop.shershnov01.Task1;

/**
 * Цей клас демонструє вирішення прикладної задачі на мові Java.
 */
public class Main {
    /**
     * Основний метод програми, який виконує вирішення задачі та виводить результат.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Генеруємо п'ятизначне випадкове число для номеру залікової книжки
        int zalikovaKnizhka = (int) (Math.random() * 90000 + 10000);

        // Номер мобільного телефону (починаючи з 380...)
        long PhoneNumber = 380669251564L;

        // Останні дві ненульові цифри номера мобільного телефону у двійковому форматі
        int lastTwoDigitsBinary = Integer.parseInt(String.valueOf(PhoneNumber).substring(9, 11), 10);

        // Останні чотири ненульові цифри номера мобільного телефону у вісімковому форматі
        int lastFourDigitsOctal = Integer.parseInt(String.valueOf(PhoneNumber).substring(6, 10), 10);

        // Знаходимо залишок від ділення на 26 зменшеного на одиницю номера студента в журналі групи
        int studentNumber = 14; // Замініть це значення на номер студента
        int remainder = (studentNumber - 1) % 26;

        // Символ англійського алфавіту в верхньому регістрі
        char alphabetChar = (char) ('A' + remainder);

        // Виводимо результати у консоль
        System.out.println("Номер залікової книжки (у шістнадцятковому форматі): 0x" + Integer.toHexString(zalikovaKnizhka));
        System.out.println("Номер мобільного телефону: " + PhoneNumber);
        System.out.println("Останні дві ненульові цифри номера мобільного телефону (у двійковому форматі): " + Integer.toBinaryString(lastTwoDigitsBinary));
        System.out.println("Останні чотири ненульові цифри номера мобільного телефону (у вісімковому форматі): " + Integer.toOctalString(lastFourDigitsOctal));
        System.out.println("Залишок від ділення на 26 зменшеного на одиницю номера студента: " + remainder);
        System.out.println("Символ англійського алфавіту: " + alphabetChar);
    }
}
