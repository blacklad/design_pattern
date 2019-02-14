package com.black.structional.proxy;

public class Printer implements Printable {
    private String name;

    public Printer(String name) {
        this.name = name;
        HeavyJob();
    }

    private void HeavyJob() {
        System.out.println("创建 Printer中");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("=====" + name + "=======");
    }
}
