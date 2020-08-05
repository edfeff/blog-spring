package com.wpp;

import com.wpp.dao.UserDao;
import com.wpp.model.Users;
import com.wpp.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws ParseException {
        System.setProperty("logging.level.org.springframework.jdbc.datasource", "DEBUG");
        System.setProperty("logging.level.org.springframework.jdbc.support", "DEBUG");

        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        UserService userService = context.getBean(UserService.class);
        userService.countUser();

        UserDao dao = context.getBean(UserDao.class);
        System.out.println(dao.findUserCountByFirstName("John0"));
        System.out.println(dao.findFirstNameById(1));


        Users john = dao.findByUserId(1);
        System.out.println(john);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        dao.findUserListByDate(format.parse("2020-07-01")).forEach(System.out::println);

        dao.findUserListByDateSimple(format.parse("2020-07-01")).forEach(System.out::println);


        dao.insertUser(new Users(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new Date(), new Date()));

        dao.deleteUserByFirstName("u2");

        dao.updateUser(2, new Users("u2", "l2", null, null));


    }
}
