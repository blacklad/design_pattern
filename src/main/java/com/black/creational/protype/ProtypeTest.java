package com.black.creational.protype;

import java.util.HashMap;

public class ProtypeTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen u1 = new UnderlinePen('\\');
        UnderlinePen u2 = new UnderlinePen('*');
        manager.register("warning", u1);
        manager.register("strong", u2);

        Product p1 = manager.create("warning");
        Product p2 = manager.create("strong");
        p1.use("aaaaaaaaaaaaaaaaa");
        p2.use("bbbbbbbbbbbbbbbbb");
    }
}


interface Product extends Cloneable {
    void use(String s);
    Product createClone();
}

class UnderlinePen implements Product {
    private char c;

    public UnderlinePen(char c) {
        this.c = c;
    }
    @Override
    public void use(String s) {
        System.out.print(c);
        System.out.print(s);
        System.out.println(c);
    }

    @Override
    public Product createClone(){
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}

class Manager {
    private HashMap<String, Product> showcase = new HashMap<>();

    public void register(String name, Product p) {
        showcase.put(name, p);
    }

    public Product create(String name) {
        Product p = showcase.get(name);
        if (p != null) {
            return p.createClone();
        }
        return null;
    }
}