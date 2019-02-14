package com.black.behavioral.command;

public class CommandTest {
    public static void main(String[] args) {
        Reciver reciver = new Reciver();
        Command c = new ConcreteCommand(reciver);
        Invoker invoker = new Invoker(c);
        invoker.action();
    }
}
