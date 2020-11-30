package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author wangpp
 */
public class MybatisUtil {
    private final static SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        String resource = "mybatis/config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }
}
