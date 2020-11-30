package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringJdbcTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/SpringJdbcTest.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.save(new User(null, "wpp", "111", "admin", "adada", "dadad", new Date(), new Date()));

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
