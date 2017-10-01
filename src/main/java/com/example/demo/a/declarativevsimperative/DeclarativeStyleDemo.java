package com.example.demo.a.declarativevsimperative;

import java.util.Arrays;
import java.util.List;

/**
 * Declarative style example.
 * <p>
 * Created by oleksandr.yefymov on 01.10.2017.
 */
public class DeclarativeStyleDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()                         //stream over the elements in collections
                .filter(DeclarativeStyleDemo::isEven)     //Filter the data
                .map(DeclarativeStyleDemo::incrementAndConvertToString) //Map new values
                .forEach(System.out::println);        //Iterate & perform the operation
    }

    public static String incrementAndConvertToString(Integer number) {
        return String.valueOf(++number);
    }

    public static Boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
