package com.edfeff.instantiating;

/**
 * @author wangpp
 */
public class JpaItemDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JpaItemDao{" +
                "name='" + name + '\'' +
                '}';
    }
}
