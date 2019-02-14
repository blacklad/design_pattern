package com.black.behavioral.mediator;

public class MediatorTest {
    public static void main(String[] args) {
        User tom = new User("tom");
        User lily = new User("lily");
        tom.talk("hi");
        lily.talk("hello");
    }
}
