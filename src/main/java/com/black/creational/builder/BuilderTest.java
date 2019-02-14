package com.black.creational.builder;

public class BuilderTest {
    public static void main(String[] args) {
        Builder markdownBuilder = new MarkdownBuilder();
        Director d = new Director(markdownBuilder);
        d.construct();
    }
}


class Director {
    private Builder b;
    public Director(Builder b) {
        this.b = b;
    }
    public void construct() {
        b.makeTitle("this is a title");
        b.makeBody("this is a body");
        b.makeBody("this is a body");
        b.makeBody("this is a body");
        b.close();
    }
}

abstract class Builder {
    abstract void makeTitle(String title);
    abstract void makeBody(String body);
    abstract void close();
}

class MarkdownBuilder extends Builder {
    @Override
    void makeTitle(String title) {
        System.out.println("# " + title);
    }
    @Override
    void makeBody(String body) {
        System.out.println("- " + body);
    }
    @Override
    void close() {

    }
}