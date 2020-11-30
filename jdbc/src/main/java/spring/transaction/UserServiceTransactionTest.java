package spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.User;
import spring.UserService;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceTransactionTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/transaction/UserServiceTransactionTest.xml");
        UserServiceTranscation userService = context.getBean("userService", UserServiceTranscation.class);
        User user = new User(null, "runtimeException", "xxx");
        userService.save(user);

        user = new User(null, "exception", "xxx");
        userService.saveException(user);
    }

}
