package ua.khpi.oop.shershnov01.Task3;

/**
 * Цей клас демонструє підрахунок кількості одиниць у двійковому записі чисел.
 */
public class Main {
    /**
     * Метод для підрахунку кількості одиниць у двійковому записі числа.
     *
     * @param binaryString Рядок з двійковим представленням числа.
     * @return Кількість одиниць у двійковому записі числа.
     */
    public static int countOnes(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * Основний метод програми для задачі 3, який виконує підрахунок і виводить результати.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Генеруємо п'ятизначне випадкове число для номеру залікової книжки
        int zalikovaKnizhka = (int) (Math.random() * 90000 + 10000);

        // Останні дві ненульові цифри номера залікової книжки у двійковому форматі
        String binaryZalikovaKnizhka = Integer.toBinaryString(zalikovaKnizhka);

        // Останні чотири ненульові цифри номера залікової книжки у двійковому форматі
        String binaryLastFourDigits = binaryZalikovaKnizhka.substring(binaryZalikovaKnizhka.length() - 4);

        // Викликаємо метод підрахунку кількості одиниць у двійковому записі
        int onesCountZalikovaKnizhka = countOnes(binaryZalikovaKnizhka);
        int onesCountLastFourDigits = countOnes(binaryLastFourDigits);

        // Виводимо результати підрахунку кількості одиниць у консоль
        System.out.println("Кількість одиниць у двійковому записі номера залікової книжки: " + onesCountZalikovaKnizhka);
        System.out.println("Кількість одиниць у двійковому записі останніх чотирьох ненульових цифр номера залікової книжки: " + onesCountLastFourDigits);
    }
}

