package com.black.behavioral.interpreter;

public class InterpreterTest {
    public static void main(String[] args) {
        String expression = "10 10 10 + *";
        ExpressionParse expressionParse = new ExpressionParse();
        expressionParse.parse(expression);
    }
}
