package com.cwang.java8;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Function<String, String> fn = str -> str.toUpperCase();
        System.out.println(fn.apply("admin"));

        Consumer<String> c=arg->{
            System.out.println(arg);
        };
        c.accept("hello");

    }
}
