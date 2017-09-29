package com.example.demo.b.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleksandr.yefymov on 29.09.2017.
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        numbers.forEach(System.out::println);
        numbers.forEach(number -> System.out.print(number + " "));
    }
}
