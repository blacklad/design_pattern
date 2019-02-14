package com.black.behavioral.memento.game;

public class Memento {
    protected int money;

    public Memento(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
