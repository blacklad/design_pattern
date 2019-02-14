package com.black.behavioral.visitor;

public interface IVisitor {
    void visitor(FreeCourse course);
    void visitor(PayCourse course);
}
