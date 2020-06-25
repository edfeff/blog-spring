package com.edfeff;

/**
 * @author wangpp
 */
public class NullOrEmpty {
    private String value;

    public NullOrEmpty(String value) {
        this.value = value;
    }

    public NullOrEmpty() {
    }

    @Override
    public String toString() {
        return "NullOrEmpty{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
