package com.example.demo.c.defaultstaticmethod;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * Created by oleksandr.yefymov on 29.09.2017.
 */
@FunctionalInterface
public interface Identifiable {

    String getId();

    default void printMe() {
        System.out.println("Hello, I am: " + getId());
    }

    static void printHello() {
        System.out.println("Hello");
    }
}

class Test {
    public static void main(String[] args) {
        SomeItem item = new SomeItem().setId("MY_ID");
        item.printMe();
        Identifiable.printHello();
    }
}

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
class SomeItem implements Identifiable {
    String id;

    @Override
    public String getId() {
        return id;
    }
}