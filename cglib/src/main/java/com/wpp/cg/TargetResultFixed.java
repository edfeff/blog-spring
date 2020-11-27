package com.wpp.cg;

import net.sf.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("固定值");
        return 9999;
    }
}
