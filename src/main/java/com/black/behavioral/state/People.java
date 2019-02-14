package com.black.behavioral.state;

public class People {
    public State state = DayState.getInstance();

    public void setClock(int hour) {
        if (hour < 18 && hour > 6) {
            state = DayState.getInstance();
        } else {
            state = NightState.getInstance();
        }
    }

    public void doThing(){
        state.doThing();
    }
}
