package com.epam.izh.rd.online.service;

import java.util.Arrays;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     * <p>
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base   - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base.replace(remove, "");
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     * <p>
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        int size = text.length();
        if (size > 0) {
            if (text.charAt(size - 1) == '?') {
                return true;


            }
        }
        return false;
    }

    /**
     * Реализовать функционал соединения переданных строк.
     *
     * <p>Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"} метод вернет
     * "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        StringBuilder toString = new StringBuilder();
        for (String str : elements) {
            toString.append(str);
        }
        return toString.toString();
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     * <p>
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        char[] chars = text.toCharArray();
        text = "";
        boolean isUp = false;
        StringBuilder textBuilder = new StringBuilder(text);
        for (int i = 0; i < chars.length; i++) {
            if (isUp)
                textBuilder.append(Character.toUpperCase(chars[i]));
            else
                textBuilder.append(Character.toLowerCase(chars[i]));
            isUp = !isUp;
        }
        text = textBuilder.toString();
        return text;
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     * <p>
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     * <p>
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        if (string.length() > 1) {
            string = string.replace(" ", "").toLowerCase();
            for (int i = 0; i < string.length() / 2; i++) {
                if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
