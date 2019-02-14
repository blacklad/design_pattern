package com.black.structional.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("111");
        System.out.println(p.getName());
        p.setName("222");
        System.out.println(p.getName());
        p.print();
    }
}
