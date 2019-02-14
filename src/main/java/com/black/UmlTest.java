package com.black;

public class UmlTest {
}



abstract class ParentClass {
    int field1;
    static char field2;
    abstract void methodA();

    double methodB() {
        return 0.1;
    }
}


class ChildClass extends ParentClass {

    void methodA() {

    }

    static void methodC() {

    }
}