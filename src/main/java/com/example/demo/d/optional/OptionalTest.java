package com.example.demo.d.optional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by oleksandr.yefymov on 30.09.2017.
 */
public class OptionalTest {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Optional.ofNullable(getSomeValue()).ifPresent(System.out::println);
        }

        System.out.println("<---->");
        List<Optional<String>> stringsWithNulls = IntStream.range(0, 5)
                .mapToObj(i -> getSomeValue())
                .map(Optional::ofNullable)
                .collect(Collectors.toList());
        System.out.println("Optional values: " + stringsWithNulls);

        stringsWithNulls.forEach(value ->
                value.map(String::trim)
                        .map(String::toLowerCase)
                        .ifPresent(System.out::println));

        System.out.println("<---->");
        String valueOfDefault = Optional.ofNullable(getSomeValue()).orElse("default");
        System.out.println(valueOfDefault);
    }

    private static String getSomeValue() {
        return RANDOM.nextBoolean() ? " SOME_STRING " : null;
    }
}
