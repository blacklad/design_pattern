package com.black.structional.proxy;

public class PrinterProxy implements Printable {

    private String name;
    private Printer printer;

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        if (printer != null) {
            printer.setName(name);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        if (printer == null) {
            printer = new Printer(this.name);
        }
        printer.print();
    }
}
