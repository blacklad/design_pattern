package com.black.behavioral.visitor;

public class PayCourse extends Course {
    private int price;

    public PayCourse(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }
}
