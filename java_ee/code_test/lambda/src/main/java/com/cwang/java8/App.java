package com.cwang.java8;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Date date = new Date();

        BigDecimal a = new BigDecimal("100");
        System.out.println(a);
        BigDecimal b = a.add(new BigDecimal("200"));
        System.out.println(a);
        System.out.println(b);
    }
}