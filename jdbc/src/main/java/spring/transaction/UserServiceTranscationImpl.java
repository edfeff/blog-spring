package spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import spring.User;
import spring.UserRowMapper;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceTranscationImpl implements UserServiceTranscation {
    private JdbcTemplate jdbcTemplate;

    private String insertUserSql = "insert into example.user(username, password) values (?, ?)";

    private String selectAllUserSql = "select * from example.user";

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                insertUserSql,
                new Object[]{user.getUsername(), user.getPassword()},
                new int[]{Types.VARCHAR, Types.VARCHAR}
        );
        //Spring默认只对RuntimeException，进行回滚
//        Exception不会回滚
        throw new RuntimeException("抛出RuntimeException异常，回滚把！");
    }

    @Override
    public void saveException(User user) throws Exception {
        jdbcTemplate.update(
                insertUserSql,
                new Object[]{user.getUsername(), user.getPassword()},
                new int[]{Types.VARCHAR, Types.VARCHAR}
        );
        throw new Exception("抛出异常，无法回滚！");
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(selectAllUserSql, new UserRowMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
