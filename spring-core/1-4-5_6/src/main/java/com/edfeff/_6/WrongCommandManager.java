package com.edfeff._6;


public class WrongCommandManager {

    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Object process() {
        System.out.println(String.format("handle %s", command.getName()));
        return command;
    }
}
