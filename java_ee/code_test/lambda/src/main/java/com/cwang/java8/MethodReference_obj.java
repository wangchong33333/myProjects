package com.cwang.java8;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

//对象方法引用，抽象方法需要输入参数,第一个参数最好是自定义类型
public class MethodReference_obj {

    public void not() {
        Runnable r = () -> {
        };
        Closeable c = () -> {
        };
        Supplier<String> s = () -> "";
    }

    public static void main(String[] args) {
        Consumer<Too> c1 = too -> {
            new Too().foo();
        };
        Consumer<Too> c2 = too -> {
            new Too2().foo();
        };

        Consumer<Too> c3 = Too::foo;
        c1.accept(new Too());
        c3.accept(new Too());

        BiConsumer<Too2, String> c4 = (too2, str) -> new Too2().fo(str);
        BiConsumer<Too2, String> c5 = Too2::fo;

        BiFunction<Prod, String, Integer> bf1 = (p, s) -> new Prod().fun(s);
        BiFunction<Prod, String, Integer> bf2 = (p, s) -> new Too().fun(s);
        BiFunction<Prod, String, Integer> bf3 = Prod::fun;

        Execute ex1 = (p, name, size) -> new Prod().run(name, size);
        Execute ex2 = Prod::run;
    }
}

interface Execute {
    void run(Prod p, String name, String size);
}

class Prod {

    public void run(String name, String size) {

    }

    public Integer fun(String s) {
        return 1;
    }
}

class Too {

    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("invoke");
    }
}

class Too2 {
    public void foo() {
        System.out.println("invoke");
    }

    public void fo(String str) {

    }
}


