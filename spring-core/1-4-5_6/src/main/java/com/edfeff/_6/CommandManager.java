package com.edfeff._6;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommandManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object process() {
        Command command = createCommand();
        System.out.println(String.format("handle %s", command.getName()));
        return command;
    }

    private Command createCommand() {
        //通过getBean，使得单例bean正确的使用原型bean
        return this.applicationContext.getBean("command", Command.class);
    }
}
