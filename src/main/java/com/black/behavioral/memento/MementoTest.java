package com.black.behavioral.memento;

import com.black.behavioral.memento.game.Gamer;
import com.black.behavioral.memento.game.Memento;

public class MementoTest {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(0);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 20; i++) {
            gamer.bet();
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("创建备份");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < (memento.getMoney() - 10)) {
                System.out.println("恢复备份");
                gamer.restoreMemento(memento);
            } else {
                System.out.println("保持状态");
            }
        }
        System.out.println(gamer.getMoney());
    }
}
