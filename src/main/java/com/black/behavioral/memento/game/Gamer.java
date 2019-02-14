package com.black.behavioral.memento.game;

import java.util.Random;

public class Gamer {

    private int money;
    private Random random = new Random();

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public void bet() {
        int n = random.nextInt(10);
        if (n < 3) {
            System.out.print("获得了金钱,");
            money+=10;
            System.out.println("现在有：" + money);
        } else if (n < 8) {
            System.out.print("失去了金钱,");
            money-=5;
            System.out.println("现在有：" + money);
        } else {
            System.out.print("没有操作,");
            System.out.println("现在有：" + money);
        }
    }

    public Memento createMemento() {
        return new Memento(this.money);
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
    }
}
