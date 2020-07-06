package com.edfeff;

import java.util.Properties;

/**
 * @author wangpp
 */
public class PropertiesBean {
    private Properties props;

    public PropertiesBean(Properties props) {
        this.props = props;
    }

    public PropertiesBean() {
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }
}
