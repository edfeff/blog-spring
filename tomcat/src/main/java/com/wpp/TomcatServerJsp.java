package com.wpp;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServerJsp {
    public static void main(String[] args) throws LifecycleException, ServletException {
        String docBase = "tomcat/src/main/webapp";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8000);

        tomcat.addWebapp("/", new File(docBase).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
