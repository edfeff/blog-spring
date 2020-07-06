package com.edfeff;

/**
 * @author wangpp
 */
public class ThingOne {
    private ThingTwo thingTwo;
    private ThingThree thingThree;

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree) {
        this.thingTwo = thingTwo;
        this.thingThree = thingThree;
    }

    public ThingOne() {
    }

    public void setThingTwo(ThingTwo thingTwo) {
        this.thingTwo = thingTwo;
    }

    public void setThingThree(ThingThree thingThree) {
        this.thingThree = thingThree;
    }
}

