package com.cwang.java8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Hello world!
 */
public class UnchangeableObject {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        date.setYear(date.getYear() + 1);
        System.out.println(date);

        BigDecimal a = new BigDecimal("100");
        System.out.println(a);
        BigDecimal b = a.add(new BigDecimal("200"));
        System.out.println(a);
        System.out.println(b);

        LocalDate day = LocalDate.now();
        System.out.println(day);
        LocalDate day2 = day.plusDays(1);
        System.out.println(day);
        System.out.println(day2);

        LocalDateTime time=LocalDateTime.now();
        System.out.println(time);


    }
}