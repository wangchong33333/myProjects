package com.cwang.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//构造方法引用
public class MethodReference_construct {
    public static void main(String[] args) {
        Supplier<Person> s1 = () -> new Person();
        Supplier<Person> s2 = Person::new;
        s1.get();
        s2.get();

        Supplier<List> s3 = ArrayList::new;
        Supplier<Thread> s4 = Thread::new;
        Supplier<Set> s5 = HashSet::new;
        Supplier<String> s6 = String::new;

        Consumer<Integer> c1 = age -> new Account(age);
        Consumer<Integer> c2 = Account::new;
        c2.accept(123);

        Function<String, Integer> fu = str -> Integer.valueOf(str);
        Function<String, Integer> fu1 = Integer::valueOf;
        Function<String, Account> fu2 = Account::new;
        fu2.apply("admin");
    }
}

class Account {
    public Account() {
        System.out.println("Account()");
    }

    public Account(int age) {
        System.out.println("Account(age)");
    }

    public Account(String name) {
        System.out.println("Account(name)");
    }
}

class Person {
    public Person() {
        System.out.println("new Person()");
    }
}