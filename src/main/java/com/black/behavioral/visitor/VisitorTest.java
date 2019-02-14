package com.black.behavioral.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        Course course = new FreeCourse("free course");
        Course course1 = new PayCourse("pay course", 200);

        IVisitor visitor = new Visitor();
        course.accept(visitor);
        course1.accept(visitor);
    }
}
