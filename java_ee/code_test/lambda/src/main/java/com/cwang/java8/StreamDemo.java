package com.cwang.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    static void gen1() {
        String[] arr = {"a", "b", "1", "2"};
        Stream<String> stream = Stream.of(arr);
        stream.forEach(System.out::println);
    }

    static void gen2() {
        List<String> list = Arrays.asList("a", "b", "1", "2");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    static void gen3() {
        Stream<Integer> stream = Stream.generate(() -> 1);
        stream.limit(10).forEach(System.out::println);
    }

    static void gen4() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    static void gen5() throws IOException {
        String str = "abcde12345";
        IntStream stream = str.chars();
//        stream.forEach(x -> System.out.println(x));
        stream.forEach(System.out::println);
        Files.lines(Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\com\\cwang\\java8\\UnchangeableObject.java")).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();

//        Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> {
//            System.out.println(2222);
//            return x % 2 == 0;
//        }).forEach(System.out::println);
//
//        int sum = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
//        System.out.println(sum);
//
//        Integer max = Arrays.asList(1, 2, 3, 4, 5, 6).stream().max((a, b) -> a - b).get();
//        System.out.println(max);
//
//        Integer min = Arrays.asList(1, 2, 3, 4, 5, 6).stream().min((a, b) -> a - b).get();
//        System.out.println(min);
//
//        Optional<Integer> any = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).findAny();
//        System.out.println(any);
//
//        Optional<Integer> op = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).sorted((a, b) -> b - a).findFirst();
//        System.out.println(op);
//
//        Arrays.asList("cn", "admin", "net", "io").stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
//
//        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x % 2 == 0).collect(Collectors.toList());
//        System.out.println(list);
//
//        Arrays.asList(1,3,4,2,2,5,1).stream().distinct().forEach(System.out::println);
//
//        Set<Integer> set = Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().collect(Collectors.toSet());
//        System.out.println(set);
//
//        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(50).sorted((a, b) -> b - a).skip(20).limit(10).collect(Collectors.toList());
//        System.out.println(list1);

//        String str = "11,22,33,44,55";
//        int sum = Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum();
//        System.out.println(sum
//        );

//        String str = "tomcat,nginx,apache,jetty";
//        Stream.of(str.split(",")).map(Usr::new).forEach(System.out::println);
//        Stream.of(str.split(",")).map(Pers::build).forEach(System.out::println);


        //启动时 -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");

        Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x -> {
            System.out.println(Thread.currentThread().getName());
        }).sequential().parallel().max(Integer::compareTo);
        System.out.println(max);
    }
}

class Usr {
    private String name;

    public Usr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Usr{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Pers {
    private String name;

    public static Pers build(String name) {
        Pers p = new Pers();
        p.setName(name);
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "name='" + name + '\'' +
                '}';
    }
}