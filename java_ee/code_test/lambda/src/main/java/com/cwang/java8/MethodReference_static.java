package com.cwang.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//静态方法引用
public class MethodReference_static {

    public static String put() {
        System.out.println("put method invoke");
        return "hello";
    }

    public static void con(Integer size) {
        System.out.println(size);
    }

    public static String toUpperCase(String str) {
        System.out.println(str);
        return str.toUpperCase();
    }

    public static Integer len(String ss1, String ss2) {
        return ss1.length()+ss2.length();
    }

    public static void main(String[] args) {
        Supplier<String> s = () -> put();
        Supplier<String> s1 = () -> Fun.ret();

        Supplier<String> s2 = MethodReference_static::put;
        Supplier<String> s3 = Fun::ret;
        System.out.println(s1.get());

        Consumer<Integer> c1 = (size) -> MethodReference_static.con(size);
        Consumer<Integer> c2 = MethodReference_static::con;
        c2.accept(100);

        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = str -> MethodReference_static.toUpperCase(str);
        Function<String, String> f3 = MethodReference_static::toUpperCase;
        System.out.println(f3.apply("lambda"));

        BiFunction<String, String, Integer> bf1 = (ss1, ss2) -> ss1.length() + ss2.length();
        BiFunction<String, String, Integer> bf2 = (ss1, ss2) -> MethodReference_static.len(ss1,ss2);
        BiFunction<String, String, Integer> bf3 = MethodReference_static::len;
        System.out.println(bf3.apply("java","ee"));
    }
}

class Fun {
    public static String ret() {
        System.out.println("put method invoke");
        return "hello";
    }
}
