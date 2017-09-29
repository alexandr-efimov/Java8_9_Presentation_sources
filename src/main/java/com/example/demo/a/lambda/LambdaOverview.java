package com.example.demo.a.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by oleksandr.yefymov on 29.09.2017.
 */
public class LambdaOverview {

    public static void main(String[] args) {
        differentLambdas();
        System.out.println("--------");
        comparators();
    }

    private static void comparators() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 2, 1);
        List<Integer> numbersForSortWithComparatorObj = new ArrayList<>(numbers);
        List<Integer> numbersForSortWithAnonymousComparator = new ArrayList<>(numbers);
        List<Integer> numbersForSortWithLambda = new ArrayList<>(numbers);

        numbersForSortWithComparatorObj.sort(new NumberComparator());
        numbersForSortWithAnonymousComparator.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        numbersForSortWithLambda.sort((a, b) -> a.compareTo(b));
        System.out.println(numbersForSortWithComparatorObj);
        System.out.println(numbersForSortWithAnonymousComparator);
        System.out.println(numbersForSortWithLambda);
    }

    private static void differentLambdas() {
        int firstNumber = 10;
        int secondNumber = 5;

        MathOperation addOperation = new AddOperation();
        MathOperation addOperationLambda = (a, b) -> a + b;
        MathOperation addOperationLambdaTypes = (int a, int b) -> a + b;
        MathOperation addOperationLambdaReturnWord = (int a, int b) -> {
            return a + b;
        };

        int sumOldStyle = addOperation.operation(firstNumber, secondNumber);
        System.out.println(sumOldStyle);
        System.out.println(addOperationLambda.operation(firstNumber, secondNumber));
        System.out.println(addOperationLambdaTypes.operation(firstNumber, secondNumber));
        System.out.println(addOperationLambdaReturnWord.operation(firstNumber, secondNumber));
    }
}

class NumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

class AddOperation implements MathOperation {
    @Override
    public int operation(int first, int second) {
        return first + second;
    }
}
