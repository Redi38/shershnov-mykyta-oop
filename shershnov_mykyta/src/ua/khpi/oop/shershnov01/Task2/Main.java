package ua.khpi.oop.shershnov01.Task2;

/**
 * Цей клас демонструє підрахунок кількості парних і непарних цифр у десятковому записі чисел.
 */
public class Main {
    /**
     * Метод для підрахунку кількості парних цифр в числі.
     *
     * @param number Число, в якому потрібно підрахувати парні цифри.
     * @return Кількість парних цифр в числі.
     */
    public static int countEvenDigits(long number) {
        int count = 0;
        while (number > 0) {
            long digit = number % 10;
            if (digit % 2 == 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    /**
     * Метод для підрахунку кількості непарних цифр в числі.
     *
     * @param number Число, в якому потрібно підрахувати непарні цифри.
     * @return Кількість непарних цифр в числі.
     */
    public static int countOddDigits(long number) {
        int count = 0;
        while (number > 0) {
            long digit = number % 10;
            if (digit % 2 != 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    /**
     * Основний метод програми для задачі 2, який виконує підрахунок і виводить результати.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Генеруємо п'ятизначне випадкове число для номеру залікової книжки
        int zalikovaKnizhka = (int) (Math.random() * 90000 + 10000);

        // Номер мобільного телефону (починаючи з 380...)
        long mobilePhoneNumber = 38066453781L;

        // Викликаємо методи підрахунку кількості цифр
        int evenDigitsCountZalikovaKnizhka = countEvenDigits(zalikovaKnizhka);
        int oddDigitsCountZalikovaKnizhka = countOddDigits(zalikovaKnizhka);

        int evenDigitsCountMobilePhoneNumber = countEvenDigits(mobilePhoneNumber);
        int oddDigitsCountMobilePhoneNumber = countOddDigits(mobilePhoneNumber);

        // Виводимо результати підрахунку кількості цифр у консоль
        System.out.println("Кількість парних цифр у номері залікової книжки: " + evenDigitsCountZalikovaKnizhka);
        System.out.println("Кількість непарних цифр у номері залікової книжки: " + oddDigitsCountZalikovaKnizhka);

        System.out.println("Кількість парних цифр у номері мобільного телефону: " + evenDigitsCountMobilePhoneNumber);
        System.out.println("Кількість непарних цифр у номері мобільного телефону: " + oddDigitsCountMobilePhoneNumber);
    }
}
