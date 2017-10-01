package com.example.demo.e.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Samples of Stream API usage.
 * <p>
 * Created by oleksandr.yefymov on 02.10.2017.
 */
public class StreamApiDemo {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "de", "fGH", " iJKL ", "", " mno ", "MNo");
        System.out.println("List with strings: " + strings);
        printSeparator();

        // 1 sample
        countEmptyElements(strings);

        // 2 sample
        printSeparator();
        countSomeLengthElements(strings);

        // 3 sample
        printSeparator();
        List<Integer> integers = Arrays.asList(1, 2, 14, 4, 15, 6, 21, 8, 19);
        System.out.println("List with numbers: " + integers);
        System.out.println("Highest number with JAVA 7: " + getMax(integers));
        Integer max = integers.stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println("Highest number with JAVA 8: " + max);


        // 4 sample
        printSeparator();
        System.out.println("Merged String: " + getMergedStringOfNotEmptyUsingJava7(strings, " "));
        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(" "));
        System.out.println("Merged String: " + mergedString);

        // 4.1
        printSeparator();
        IntSummaryStatistics stats = integers.stream().mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
        System.out.println("Max number: " + stats.getMax());
        System.out.println("Min number: " + stats.getMin());


        // 5 sample
        printSeparator();
        List<String> notEmptyUniqueInUpperCase = strings.stream()
                .filter(Objects::nonNull)
                .filter(string -> !string.isEmpty())
                .map(String::trim)
                .map(String::toUpperCase)
                .distinct()
                .peek(string -> System.out.print(string + " "))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(notEmptyUniqueInUpperCase);
        // Parallel? --easy!
        List<String> notEmptyUniqueInUpperCaseInParallel = strings.parallelStream()
                .filter(Objects::nonNull)
                .filter(string -> !string.isEmpty())
                .map(String::trim)
                .map(String::toUpperCase)
                .distinct()
                .peek(string -> System.out.print(string + " "))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(notEmptyUniqueInUpperCaseInParallel);

        List<String> notEmptyUniqueInUpperCaseJava7 = getNotEmptyUniqueInUpperCase(strings);
        System.out.println("With java 7:" + notEmptyUniqueInUpperCaseJava7);
    }

    private static List<String> getNotEmptyUniqueInUpperCase(List<String> strings) {
        Set<String> result = new LinkedHashSet<>();
        for (String string : strings) {
            if (string != null && !string.isEmpty()) {
                String convertedString = string.trim().toUpperCase();
                result.add(convertedString);
            }
        }

        return new ArrayList<>(result);
    }

    private static String getMergedStringOfNotEmptyUsingJava7(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {

            if (!string.isEmpty()) {
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.toString();
    }

    private static int getMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------------------");
    }

    private static void countSomeLengthElements(List<String> strings) {
        int length = 3;
        long count = getCountLengthUsingJava7(strings, length);
        System.out.println("With some length -Java 7-->" + count);
        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("With some length -Java 8-->" + count);
    }

    private static void countEmptyElements(List<String> strings) {
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty -Java 7-->" + count);


        count = strings.stream().filter(String::isEmpty).count();
        System.out.println("Empty -Java 8-->" + count);
    }

    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;

        for (String string : strings) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }


    private static int getCountLengthUsingJava7(List<String> strings, int length) {
        int count = 0;

        for (String string : strings) {
            if (string.length() == length) {
                count++;
            }
        }
        return count;
    }
}
