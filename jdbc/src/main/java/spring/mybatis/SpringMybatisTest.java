package spring.mybatis;

import mybatis.User;
import mybatis.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 配置 mybatis
 *
 * @author wangpp
 */
public class SpringMybatisTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
