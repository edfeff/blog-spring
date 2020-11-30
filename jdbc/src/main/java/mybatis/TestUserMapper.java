package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author wangpp
 */
public class TestUserMapper {
    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User wpp = new User("wpp", "121");

            mapper.insertUser(wpp);
            sqlSession.commit();

            User user = mapper.getUser(1);
            System.out.println(user);

        } finally {
            sqlSession.close();
        }
    }
}
