package com.wpp;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TomcatServerOne {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8000);
        Context context = tomcat.addContext("/", new File(".").getAbsolutePath());

        tomcat.addServlet(context, "embed", new InnerHttpServelt());

        context.addServletMapping("/*", "embed");

        tomcat.start();
        tomcat.getServer().await();
    }

    static class InnerHttpServelt extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter writer = resp.getWriter();
            writer.write("hello! \n---from tomcat.");
            writer.flush();
            writer.close();
        }
    }
}
