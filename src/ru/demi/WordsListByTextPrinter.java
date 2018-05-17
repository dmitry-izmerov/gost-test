package ru.demi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * На вход программе подается литературный текст.
 * Программа должна вывести список слов, встречающихся в тексте,
 * в котором для каждого слова указывается количество вхождений этого слова в текст,
 * а слова выводятся в порядке убывания частоты вхождения.
 */
public class WordsListByTextPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mes = "Программа выводит список слов, встречающихся в тексте,\n" +
            " в котором для каждого слова указывается количество вхождений этого слова в текст,\n" +
            " а слова выводятся в порядке убывания частоты вхождения.";
        System.out.println(mes);
        System.out.println("Введите текст:");

        List<String> words = new ArrayList<>();
        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            words.addAll(Arrays.asList(line.split("\\P{L}+"))); // by not unicode letters
        }

        System.out.println("Результат:");
        getWordsWithCounts(words).forEach((word, count) -> {
            System.out.println(String.format("Слово: %s, количество вхождений: %d", word, count));
        });
    }

    private static Map<String, Long> getWordsWithCounts(List<String> words) {
        Map<String, Long> grouped = words.stream()
            .collect(groupingBy(Function.identity(), counting()));

        return grouped.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue,
                LinkedHashMap::new
            ));
    }
}
