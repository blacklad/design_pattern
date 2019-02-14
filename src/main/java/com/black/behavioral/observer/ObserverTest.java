package com.black.behavioral.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObserverTest {
    public static void main(String[] args) {
        Observer observer = new DigitObserver();
        Observer observer1 = new GraphObserver();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        numberGenerator.addObserver(observer);
        numberGenerator.addObserver(observer1);

        numberGenerator.execute();

    }
}

interface Observer {
    void update(NumberGenerator generator);
}

class DigitObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println(generator.getNum());
    }
}

class GraphObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        int count = generator.getNum();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
abstract class NumberGenerator {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            it.next().update(this);
        }
    }
    abstract int getNum();
    abstract void execute();
}

class RandomNumberGenerator extends NumberGenerator {
    private int num;
    private static Random random = new Random();

    @Override
    int getNum() {
        return num;
    }

    @Override
    void execute() {
        for (int i = 0; i < 20; i++) {
            num = random.nextInt(100);
            notifyObservers();
        }
    }
}

