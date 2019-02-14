package com.black.behavioral.strategy;

import java.util.Random;

public class StrategyTest {
    public static void main(String[] args) {
        Player player1 = new Player("a", new WiningStrategy());
        Player player2 = new Player("b", new ProbStrategy());

        for (int i = 0; i < 10000; i++) {
            int h1 = player1.nextHand();
            int h2 = player2.nextHand();

            if (h1 == h2) {
                player1.even();
                player2.even();
            }
            else if ((h1+1) % 3 == h2) {
                player1.win();
                player2.lose();
            } else {
                player1.lose();
                player2.win();
            }
        }

        System.out.println(player1);
        System.out.println(player2);
    }
}


class Player {
    private String name;
    private Strategy strategy;

    private int losecount;
    private int wincount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public int nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "name: " + name + " wincount: " + wincount + " gamecount: " + gamecount;
    }
}

abstract class Strategy {
    abstract int nextHand();
    abstract void study(boolean isWin);
}

class WiningStrategy extends Strategy {
    public static Random random = new Random();
    public boolean preWin;
    public int hand;

    @Override
    int nextHand() {
        if (!preWin) {
            hand = random.nextInt(3);
        }
        return hand;
    }

    @Override
    void study(boolean isWin) {
        this.preWin = isWin;
    }
}

class ProbStrategy extends Strategy {
    private Random random = new Random();


    public  int[][] history = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
    };
    public int prehand = 0;
    public int currhand = 0;

    @Override
    int nextHand() {
        int n = random.nextInt(getSum(currhand));
        int hand = 0;
        if (n < history[currhand][0]) {
            hand = 0;
        } else if (n < history[currhand][0] + history[currhand][1]) {
            hand = 1;
        } else {
            hand = 2;
        }
        prehand = currhand;
        currhand = hand;
        return hand;
    }

    private int getSum(int hand) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hand][i];
        }
        return sum;
    }

    @Override
    void study(boolean isWin) {
        if (isWin) {
            history[prehand][currhand]++;
        }
    }
}