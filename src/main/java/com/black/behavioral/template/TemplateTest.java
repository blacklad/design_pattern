package com.black.behavioral.template;

public class TemplateTest {
    public static void main(String[] args) {
        AbstractDisplay c = new CharDisplay('a');
        c.display();


        AbstractDisplay s = new StringDisplay("abcdefgh");
        s.display();
    }
}



abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

class CharDisplay extends AbstractDisplay {

    private char c;

    public CharDisplay(char c) {
        this.c = c;
    }


    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(c);
    }

    @Override
    public void close() {
        System.out.print(">>");
    }
}


class StringDisplay extends AbstractDisplay {
    private String s;

    public StringDisplay(String s) {
        this.s = s;
    }

    @Override
    public void open() {
        System.out.println("\"");
    }

    @Override
    public void print() {
        System.out.println(s);
    }

    @Override
    public void close() {
        System.out.println("\"");
    }
}