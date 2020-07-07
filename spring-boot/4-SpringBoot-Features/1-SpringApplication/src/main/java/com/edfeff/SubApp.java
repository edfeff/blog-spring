package com.edfeff;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class SubApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SubApp.class);
//        关闭 banner
//        application.setBannerMode(Banner.Mode.OFF);
//         关闭启动日志
        application.setLogStartupInfo(false);

        //关闭延迟初始化,注意优先级,外部配置文件具有较高的优先级
        application.setLazyInitialization(false);

        //设置自定义的banner
        application.setBanner((environment, sourceClass, out) -> {

            out.println("====================");
            out.println("自定义的banner");
            out.println("====================");
        });

        application.run(args);
    }
}
