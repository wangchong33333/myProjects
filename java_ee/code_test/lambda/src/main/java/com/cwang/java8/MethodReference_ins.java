package com.cwang.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//实例方法引用
public class MethodReference_ins extends MethodReference_ins_base{

    public String put() {
        return "hello";
    }

    public void con(Integer size) {
        System.out.println(size);
    }

    public String toUpperCase(String str) {
        System.out.println(str);
        return str.toUpperCase();
    }

    public void test(){
        Function<String, String> f2 = this::toUpperCase;
        System.out.println(f2.apply("javaee"));

        Function<String, String> f3 = super::toUpperCase;
        System.out.println(f3.apply("javaee"));
    }

    public static void main(String[] args) {
        Supplier<String> s = () -> new MethodReference_ins().put();
        Supplier<String> s1 = () -> {
            return new MethodReference_ins().put();
        };
        Supplier<String> s2 = new MethodReference_ins()::put;
        System.out.println(s2.get());

        MethodReference_ins methodReference_ins = new MethodReference_ins();
        methodReference_ins.test();

        Consumer<Integer> c1 = (size) -> new MethodReference_ins().con(size);
        Consumer<Integer> c2 = new MethodReference_ins()::con;
        Consumer<Integer> c3 = methodReference_ins::con;
        c2.accept(100);
        c3.accept(100);

        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = methodReference_ins::toUpperCase;
        System.out.println(f2.apply("javaee"));
    }
}