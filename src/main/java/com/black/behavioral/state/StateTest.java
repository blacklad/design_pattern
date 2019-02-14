package com.black.behavioral.state;

public class StateTest {
    public static void main(String[] args) {
        People p = new People();
        for (int i = 0; i < 24; i++) {
            p.setClock(i);
            p.doThing();
        }
    }
}
