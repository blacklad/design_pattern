package com.black.behavioral.visitor;

public class Visitor implements IVisitor {
    @Override
    public void visitor(FreeCourse course) {
        System.out.println("free course: " + course.getName());
    }

    @Override
    public void visitor(PayCourse course) {
        System.out.println("pay course: " + course.getName() + " price: " + course.getPrice());

    }
}
