package com.edfeff._5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AutoWireArrayBean {
    private BeanA[] as;
    private List<BeanB> bs;
    private Map<String, BeanA> map;

    public AutoWireArrayBean() {
    }

    public BeanA[] getAs() {
        return as;
    }

    public void setAs(BeanA[] as) {
        this.as = as;
    }

    public List<BeanB> getBs() {
        return bs;
    }

    public void setBs(List<BeanB> bs) {
        this.bs = bs;
    }

    public Map<String, BeanA> getMap() {
        return map;
    }

    public void setMap(Map<String, BeanA> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "AutoWireArrayBean{" +
                "as=" + Arrays.toString(as) +
                ", bs=" + bs +
                ", map=" + map +
                '}';
    }
}
