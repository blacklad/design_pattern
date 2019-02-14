package com.black.creational.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();

    }
}

class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("create a object");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}