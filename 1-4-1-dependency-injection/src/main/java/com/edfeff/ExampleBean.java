package com.edfeff;

import java.beans.ConstructorProperties;

/**
 * @author wangpp
 */
public class ExampleBean {
    private int years;
    private String ultimateAnswer;

    @ConstructorProperties( {"years", "ultimateAnswer"} )
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

   /* public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }*/
}
