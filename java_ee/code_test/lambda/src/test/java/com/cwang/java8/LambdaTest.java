package com.cwang.java8;

import com.cwang.java8.bean.Book;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    /**
     * index.do?itemId=1&userId=10000&type=20&token=sadfasfasfdasdf&key=index
     */
    @Test
    public void test1() {
        String queryString = "itemId=1&userId=10000&type=20&token=sadfasfasfdasdf&key=index";
        Map<String, String> map = Stream.of(queryString.split("&")).map(str -> str.split("=")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
        System.out.println(map);
    }

    @Test
    public void test2() {
        List<Integer> ids = books().stream().map(book -> book.getId()).collect(Collectors.toList());
        System.out.println(ids);

        ids = books().stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(ids);

        String s = books().stream().map(book -> "'" + book.getId() + "'").collect(Collectors.joining(",", "(", ")"));
        System.out.println(s);
    }

    @Test
    public void test3() {
        List<String> types = books().stream().map(book -> book.getType()).distinct().collect(Collectors.toList());
        System.out.println(types);
    }

    @Test
    public void test4() {
//        Comparator<Book> comparable = Comparator.comparing(Book::getPrice);
//        books().stream().sorted(comparable.reversed().thenComparing((book1, book2) -> book1.getPublishDate().isAfter(book2.getPublishDate()) ? 1 : -1)).forEach(System.out::println);

        books().stream().sorted(Comparator.comparing(Book::getPrice).reversed().thenComparing(Comparator.comparing(Book::getPublishDate).reversed())).forEach(System.out::println);
    }

    @Test
    public void test5() {
        Map<Integer, Book> map = books().stream().collect(Collectors.toMap(Book::getId, book -> book));
        System.out.println(map);
    }

    //collct平均数
    @Test
    public void test6() {
        Double aDouble = books().stream().collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println(aDouble);
    }

    @Test
    public void test7() {
        Optional<Book> op = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
        System.out.println(op);

        op = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice)));
        System.out.println(op);

        op = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate))));
        System.out.println(op);
    }

    @Test
    public void test8() {
        Map<String, List<Book>> booksMap = books().stream().collect(Collectors.groupingBy(Book::getType));
        System.out.println(booksMap);

        Map<String, Long> map = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.counting()));
        System.out.println(map);

        Map<String, Double> priceMap = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.summingDouble(Book::getPrice)));
        System.out.println(priceMap);

        Map<String, Double> averMap = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.averagingDouble(Book::getPrice)));
        System.out.println(averMap);

        Map<String, Optional<Book>> opMap = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(opMap);

        opMap = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.minBy(Comparator.comparing(Book::getPrice))));
        System.out.println(opMap);

        opMap = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate)))));
        System.out.println(opMap);
    }

    private List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "tomcat", 70d, "服务器", LocalDate.parse("2014-05-17")));
        books.add(new Book(2, "jetty", 60d, "服务器", LocalDate.parse("2015-12-01")));
        books.add(new Book(3, "nginx", 65d, "服务器", LocalDate.parse("2016-10-17")));
        books.add(new Book(4, "java", 66d, "编程语言", LocalDate.parse("2011-04-09")));
        books.add(new Book(5, "ruby", 80d, "编程语言", LocalDate.parse("2013-05-09")));
        books.add(new Book(6, "php", 40d, "编程语言", LocalDate.parse("2014-08-06")));
        books.add(new Book(7, "html", 44d, "编程语言", LocalDate.parse("2011-01-06")));
        books.add(new Book(8, "oracle", 150d, "数据库", LocalDate.parse("2013-08-09")));
        books.add(new Book(9, "mysql", 66d, "数据库", LocalDate.parse("2015-04-06")));
        books.add(new Book(10, "ssh", 70d, "编程语言", LocalDate.parse("2016-12-04")));
        books.add(new Book(11, "设计模式", 81d, "其他", LocalDate.parse("2017-04-06")));
        books.add(new Book(12, "重构", 62d, "其他", LocalDate.parse("2012-04-09")));
        books.add(new Book(13, "敏捷开发", 72d, "其他", LocalDate.parse("2016-09-07")));
        books.add(new Book(14, "从技术到管理", 42d, "其他", LocalDate.parse("2016-02-19")));
        books.add(new Book(15, "算法导论", 66d, "其他", LocalDate.parse("2010-05-08")));
        books.add(new Book(16, "oracle 12c", 150d, "数据库", LocalDate.parse("2017-05-08")));
        return books;
    }
}
