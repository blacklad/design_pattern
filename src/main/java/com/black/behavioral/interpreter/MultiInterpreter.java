package com.black.behavioral.interpreter;

public class MultiInterpreter implements Interpreter {

    private Interpreter interpreter1, interpreter2;

    public MultiInterpreter(Interpreter interpreter1, Interpreter interpreter2) {
        this.interpreter1 = interpreter1;
        this.interpreter2 = interpreter2;
    }


    @Override
    public int interpreter() {
        return interpreter1.interpreter() * interpreter2.interpreter();
    }
}
