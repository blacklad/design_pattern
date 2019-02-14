package com.black.behavioral.command;

public class ConcreteCommand implements Command {
    private Reciver reciver;

    public ConcreteCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void execute() {
        reciver.doThing();
    }
}
