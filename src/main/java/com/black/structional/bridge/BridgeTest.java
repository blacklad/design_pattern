package com.black.structional.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        CountDisplay cd1 = new CountDisplay(new StringDisplayImpl(), 5);
        CountDisplay cd2 = new CountDisplay(new StringDisplayImpl(), 2);

        cd1.multiDisplay();
        cd2.multiDisplay();
    }
}

class Display {
    protected DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    void open() {
        impl.rawOpen();
    }

    void print() {
        impl.rawPrint();
    }

    void close() {
        impl.rawClose();
    }
}

class CountDisplay extends Display {

    private int count;

    public CountDisplay(DisplayImpl impl,  int count) {
        super(impl);
        this.count = count;
    }

    void multiDisplay() {
        impl.rawOpen();
        for (int i = 0; i < count; i++) {
            impl.rawPrint();
        }
        impl.rawClose();
    }
}

abstract  class DisplayImpl {
    abstract void rawOpen();
    abstract void rawPrint();
    abstract void rawClose();
}

class StringDisplayImpl extends DisplayImpl {

    @Override
    void rawOpen() {
        System.out.println("open");
    }

    @Override
    void rawPrint() {
        System.out.println("print");
    }

    @Override
    void rawClose() {
        System.out.println("close");
    }
}