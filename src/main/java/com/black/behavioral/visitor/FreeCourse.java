package com.black.behavioral.visitor;

public class FreeCourse extends Course {

    public FreeCourse(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }
}
