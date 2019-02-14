package com.black.structional.flyweight;

public class DigitChar {
    private int name;
    private String content;

    public DigitChar(int name) {
        this.name = name;
        this.content = "#" + name + "#";
    }

    public void print() {
        System.out.print(content);
    }
}
