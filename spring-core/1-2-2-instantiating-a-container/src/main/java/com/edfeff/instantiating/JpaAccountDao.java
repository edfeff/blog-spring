package com.edfeff.instantiating;

/**
 * @author wangpp
 */
public class JpaAccountDao {
    private String name;

    public JpaAccountDao(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JpaAccountDao{" +
                "name='" + name + '\'' +
                '}';
    }
}
