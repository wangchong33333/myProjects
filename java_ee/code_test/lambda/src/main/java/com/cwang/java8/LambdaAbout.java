package com.cwang.java8;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaAbout {
    static void test() throws Exception {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        r1.run();

        Runnable r2 = () -> {
            System.out.println("run");
        };
        r2.run();

        Runnable r3 = () -> System.out.println("run");
        r3.run();

        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        };

        Callable<String> c2 = () -> {
            return "hello";
        };
        Callable<String> c3 = () -> "hello";

        System.out.println(c1.call());
        System.out.println(c2.call());
        System.out.println(c3.call());

        UserMapper u1 = new UserMapper() {
            @Override
            public void insert(User user) {
                System.out.println("insert user:" + user);
            }
        };

        UserMapper u2 = (user) -> {
            System.out.println("insert user:" + user);
        };
        UserMapper u3 = (User user) -> System.out.println("insert user:" + user);

        u1.insert(new User());
        u2.insert(new User());
        u3.insert(new User());

        OrderMapper o1 = new OrderMapper() {
            @Override
            public int insert(Order order) {
                System.out.println("insert order:" + order);
                return 1;
            }
        };

        OrderMapper o2 = (order) -> {
            return 1;
        };
        OrderMapper o3 = (Order order) -> {
            return 1;
        };
        OrderMapper o4 = (order) -> 1;
        OrderMapper o5 = (Order order) -> 1;

        System.out.println(o1.insert(new Order()));
        System.out.println(o2.insert(new Order()));
        System.out.println(o3.insert(new Order()));
        System.out.println(o4.insert(new Order()));
        System.out.println(o5.insert(new Order()));

        Function<Integer, Integer> f1 = a -> {
            int sum = 0;
            for (int i = 0; i < a; i++) {
                sum += i;
            }
            return sum;
        };

        System.out.println(f1.apply(10));
    }

    public static void main(String[] args) {
        Runnable r1 = () -> get();
        Runnable r2 = () -> exec();
        Runnable r3 = () -> find();//没有reture
//        Runnable r4=()->100;//error,必有reture

        Foo f1 = () -> get();
//        Foo f2 = () -> exec();//error
//        Foo f3 = () -> find();//error
        Foo f4 = () -> 100;
        Foo f5 = () -> true ? 1 : -1;

        BiFunction<String, String, Integer> bf = (a, b) -> a.length() + b.length();
        System.out.println(bf.apply("java", "ee"));

        BiFunction<String, String, Integer> bf1 = (a, b) -> {
            //doing
            return 1;
        };

        Function<String, Integer> f6 = a -> a.length();
    }

    static int get() {
        return 1;
    }

    static String find() {
        return "";
    }

    static void exec() {

    }
}

interface UserMapper {
    void insert(User user);
}

interface OrderMapper {
    int insert(Order order);
}

interface Foo {
    int get();
}

class User {

}

class Order {

}
