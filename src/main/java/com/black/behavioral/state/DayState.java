package com.black.behavioral.state;

public class DayState implements State {

    private static State state = new DayState();

    public static State getInstance() {
        return state;
    }

    @Override
    public void doThing() {
        System.out.println("run");
    }
}
