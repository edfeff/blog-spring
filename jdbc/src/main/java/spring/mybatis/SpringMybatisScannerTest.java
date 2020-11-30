package spring.mybatis;

import mybatis.User;
import mybatis.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 配置 mybatis
 *
 * @author wangpp
 */
public class SpringMybatisScannerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/mybatis_auto/spring-mybatis.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.getUser(2);
        System.out.println(user);
    }
}
