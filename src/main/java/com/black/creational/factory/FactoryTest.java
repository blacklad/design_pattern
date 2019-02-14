package com.black.creational.factory;

public class FactoryTest {


    public static void main(String[] args) {
        Product p1 = new IDCardFactory().creat("aa");
        Product p2 = new IDCardFactory().creat("bb");

        p1.use();
        p2.use();
    }
}

abstract class Product {
    abstract void use();
}

abstract class Factory {
    public Product creat(String own) {
        Product p = createProduct(own);
        return p;
    }
    public abstract Product createProduct(String own);
}

class IDCard extends Product {

    private String own;

    IDCard(String own) {
        this.own = own;
    }

    @Override
    void use() {
        System.out.println("-----------use " + own + " card--------");
    }
}

class IDCardFactory extends Factory {

    @Override
    public Product createProduct(String own) {
        return new IDCard(own);
    }
}