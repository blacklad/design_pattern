package com.black.behavioral.chainofresponsibility;

public class ChanOfResponsibilityText {
    public static void main(String[] args) {
        Support support3 = new NoSupport("NO");
        Support support1 = new LimitSupport("limit");
        Support support2 = new OddSupport("odd");


        support3.setNext(support2).setNext(support1);

        for (int i = 0; i < 30; i++) {
            support3.support(new Trouble(i));
        }
    }
}

class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}

abstract class Support {
    private String name;
    public Support next;

    public Support(String name) {
        this.name = name;
    }

    public final void support(Trouble t) {
        if (resolve(t)) {
            done(t);
        } else if (next != null) {
            next.support(t);
        } else {
            fail(t);
        }
    }

    private void fail(Trouble t) {
        System.out.println("[" + name + "]" + "resolve fail " + t.getNumber());
    }

    private void done(Trouble t) {
        System.out.println("[" + name + "]" + "resolve succ " + t.getNumber());
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    abstract boolean resolve(Trouble t);
}

class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    boolean resolve(Trouble t) {
        return false;
    }
}

class LimitSupport extends Support {

    public LimitSupport(String name) {
        super(name);
    }

    @Override
    boolean resolve(Trouble t) {
        if (t.getNumber() < 10) {
           return true;
        }
        return false;
    }
}

class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    boolean resolve(Trouble t) {
        if (t.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}