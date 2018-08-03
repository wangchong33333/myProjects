package com.cwang.java8;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

    int delete();

    int hashCode();

    default int insert(){
        return 1;
    }

    static int update(){
        return 1;
    }
}
