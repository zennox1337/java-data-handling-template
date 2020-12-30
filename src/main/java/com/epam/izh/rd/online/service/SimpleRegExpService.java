package com.epam.izh.rd.online.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        StringBuilder fileContent;
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\" + "sensitive_data.txt"))) {
            fileContent = new StringBuilder(reader.readLine());
        } catch (IOException e) {
            return e.getMessage();
        }
        Pattern pattern = Pattern.compile("\\d{4} (\\d{4}) (\\d{4}) \\d{4}");
        Matcher matcher = pattern.matcher(fileContent);
        String string = fileContent.toString();
        String hide = "****";
        while (matcher.find()) {
            string = string.replace(matcher.group(1), hide).replace(matcher.group(2), hide);
        }
        return string;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        StringBuilder fileContent;
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\" + "sensitive_data.txt"))) {
            fileContent = new StringBuilder(reader.readLine());
        } catch (IOException e) {
            return e.getMessage();
        }
        Pattern pattern = Pattern.compile("(\\$\\{.*?})");
        Matcher match = pattern.matcher(fileContent);
        String str = fileContent.toString();
        while (match.find()) {
            if (match.group(1).contains("payment_amount"))
                str = str.replace(match.group(1), String.valueOf((int) paymentAmount));
            else if (match.group(1).contains("balance"))
                str = str.replace(match.group(1), String.valueOf((int) balance));
        }
        return str;
    }
}
