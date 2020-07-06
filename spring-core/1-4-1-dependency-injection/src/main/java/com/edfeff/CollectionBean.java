package com.edfeff;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author wangpp
 */
public class CollectionBean {
    private Properties properties;
    private List list;
    private Set set;
    private Map map;

    public CollectionBean(Properties properties, List list, Set set, Map map) {
        this.properties = properties;
        this.list = list;
        this.set = set;
        this.map = map;
    }

    public CollectionBean() {
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "properties=" + properties +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
