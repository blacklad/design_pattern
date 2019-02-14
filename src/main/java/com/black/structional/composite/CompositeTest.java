package com.black.structional.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeTest {
    public static void main(String[] args) {
        File f1 = new File("aa",100);
        File f2 = new File("bb",200);

        Directory d1 = new Directory("root");
        d1.add(f1);
        d1.add(f2);

        d1.printList();
    }
}

abstract class Entry {
    public String name;

    public Entry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract int getSize();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String s);

    public void add() {
        throw new RuntimeException("error");
    }

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}

class File extends Entry {
    public int size;
    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    protected void printList(String s) {
        System.out.println(s + "/" + this);
    }
}

class Directory extends Entry {
    public ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void add(Entry e) {
        directory.add(e);
    }

    @Override
    protected int getSize() {
        int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size;
    }

    @Override
    protected void printList(String s) {
        System.out.println(s + "/" + this);

        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            it.next().printList(s + "/" + name);
        }
    }
}
