package com.black.behavioral.interpreter;

import java.util.Stack;

public class ExpressionParse {

    private Stack<NumberInterpreter> stack = new Stack<>();


    void parse(String expression) {
        String[] expressions = expression.split(" ");

        for (String e : expressions ) {
            if (!isOperator(e)) {
                NumberInterpreter numberInterpreter = new NumberInterpreter(e);
                stack.push(numberInterpreter);
            } else {
                NumberInterpreter numberInterpreter1 = stack.pop();
                NumberInterpreter numberInterpreter2 = stack.pop();
                Interpreter interpreter = getInterpreter(numberInterpreter1, numberInterpreter2, e);
                int num = interpreter.interpreter();
                stack.push(new NumberInterpreter(num));
            }
        }

        System.out.println("结果为：" + stack.pop().interpreter());
    }

    static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("*")) {
            return true;
        }
        return false;
    }

    static Interpreter getInterpreter(NumberInterpreter numberInterpreter1, NumberInterpreter numberInterpreter2, String symbol) {
        if (symbol.equals("*")) {
            return new MultiInterpreter(numberInterpreter1,numberInterpreter2);
        } else if (symbol.equals("+")) {
            return new AddInterpreter(numberInterpreter1,numberInterpreter2);
        }
        return null;
    }


}
