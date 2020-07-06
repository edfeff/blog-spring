package com.edfeff._6;

import java.util.UUID;

public class Command {
    private String name;

    public Command() {
        this.name = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

}
