package ua.khpi.oop.shershnov06.Task;

/**
 * Клас TextProcessor для обробки тексту.
 */
public class TextProcessor {
    private String inputText;
    private char endingChar;
    private String insertString;

    /**
     * Встановлює вхідний текст для обробки.
     *
     * @param inputText Вхідний текст.
     */
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    /**
     * Встановлює символ, яким закінчуються слова.
     *
     * @param endingChar Символ, яким закінчуються слова.
     */
    public void setEndingChar(char endingChar) {
        this.endingChar = endingChar;
    }

    /**
     * Встановлює рядок, який вставляється після кожного слова.
     *
     * @param insertString Рядок, який потрібно вставити після кожного слова.
     */
    public void setInsertString(String insertString) {
        this.insertString = insertString;
    }

    /**
     * Обробляє встановлений вхідний текст, вставляючи рядок після слів, що закінчуються заданим символом.
     *
     * @return Результат обробки тексту.
     */
    public String processText() {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : inputText.toCharArray()) {
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
