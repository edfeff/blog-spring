package com.edfeff.consuming.rest;


public class EventRecord {
    private Long start;
    private Long end;
    private String msg;

    public EventRecord(String msg, Long start, Long end) {
        this.start = start;
        this.end = end;
        this.msg = msg;
    }

    public static EventRecord parse(String record) {
        String[] data = record.split("#");
        return new EventRecord(data[0], Long.valueOf(data[1]), Long.valueOf(data[2]));
    }

    @Override
    public String toString() {
        return String.format("%s#%d#%d", msg, start, end);
    }
}
