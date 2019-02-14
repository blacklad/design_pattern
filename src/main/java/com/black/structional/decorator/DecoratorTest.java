package com.black.structional.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Display display = new StringDisplay("aaaaaa");

        Display display1 = new FullBorder(
                new SideBorder(
                        new FullBorder(
                                new SideBorder(
                                        new SideBorder(display, '$'), '#'
                                )
                        ),'*'
                ));

        display1.show();
    }
}


abstract class Display {
    abstract int getRows();
    abstract int getColumns();

    abstract String getRowText(int i);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}

class StringDisplay extends Display {

    private String s;

    public StringDisplay(String s) {
        this.s = s;
    }

    @Override
    int getRows() {
        return 1;
    }

    @Override
    int getColumns() {
        return s.getBytes().length;
    }

    @Override
    String getRowText(int i) {
        return s;
    }
}

abstract class Border extends Display {
    protected Display display;

    public Border(Display display) {
        this.display = display;
    }
}

class SideBorder extends Border {

    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    int getRows() {
        return display.getRows();
    }

    @Override
    int getColumns() {
        return display.getColumns()+2;
    }

    @Override
    String getRowText(int i) {
        return borderChar + display.getRowText(i) + borderChar;
    }
}


class FullBorder extends Border {


    public FullBorder(Display display) {
        super(display);
    }

    @Override
    int getRows() {
        return display.getRows() + 2;
    }

    @Override
    int getColumns() {
        return display.getColumns() + 2;
    }

    @Override
    String getRowText(int i) {
        if (i == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (i == display.getRows() + 1) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(i - 1) + "|";
        }
    }

    String makeLine(char c, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
