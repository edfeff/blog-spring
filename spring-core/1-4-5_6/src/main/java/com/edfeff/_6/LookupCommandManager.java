package com.edfeff._6;

public abstract class LookupCommandManager {
    public Object process() {
        Command command = createCommand();
        System.out.println(String.format("handle %s", command.getName()));
        return command;
    }

    protected abstract Command createCommand();
}
