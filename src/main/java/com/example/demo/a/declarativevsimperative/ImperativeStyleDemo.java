package com.example.demo.a.declarativevsimperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Imperative style example.
 * <p>
 * Created by oleksandr.yefymov on 01.10.2017.
 */
public class ImperativeStyleDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<String> resultValues = new ArrayList<>();
        for (Integer number : numbers) {
            if (isEven(number))
                resultValues.add(ImperativeStyleDemo.incrementAndConvertToString(number));
        }

        for (String number : resultValues) {
            System.out.println(number);
        }
    }

    public static String incrementAndConvertToString(Integer number) {
        return String.valueOf(++number);
    }

    public static Boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}