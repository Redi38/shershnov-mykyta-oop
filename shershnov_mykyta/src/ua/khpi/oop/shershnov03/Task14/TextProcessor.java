package ua.khpi.oop.shershnov03.Task14;

/**
 * Клас TextProcessor для обробки тексту.
 */
public class TextProcessor {
    /**
     * Метод для обробки тексту, вставки рядка після слів, що закінчуються заданим символом.
     *
     * @param text         Вхідний текст.
     * @param endingChar   Символ, яким закінчуються слова.
     * @param insertString Рядок, який потрібно вставити після кожного слова.
     * @return Результат обробки тексту.
     */
    public static String processText(String text, char endingChar, String insertString) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) || c == '\'') {
                word.append(c);
            } else {
                if (word.length() > 0 && word.charAt(word.length() - 1) == endingChar) {
                    result.append(word).append(insertString);
                } else {
                    result.append(word);
                }
                word.setLength(0);
                result.append(c);
            }
        }

        // Обробити останнє слово, якщо текст закінчується на слово
        if (word.length() > 0 && word.charAt(word.length() - 1) == endingChar) {
            result.append(word).append(insertString);
        } else {
            result.append(word);
        }

        return result.toString();
    }
}

