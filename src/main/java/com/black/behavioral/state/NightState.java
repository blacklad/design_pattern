package com.black.behavioral.state;

public class NightState implements State {
    private static State state = new NightState();

    public static State getInstance() {
        return state;
    }

    @Override
    public void doThing() {
        System.out.println("sleep");
    }
}
