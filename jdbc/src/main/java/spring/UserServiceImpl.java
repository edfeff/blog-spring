package spring;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    private String insertUserSql = "INSERT INTO godmin.goadmin_users " +
            "(username, password, name, avatar, remember_token, created_at, updated_at) " +
            "VALUES " +
            "(?,?, ?, ?, ?, ?, ?)";

    private String selectAllUserSql = "select * from godmin.goadmin_users";

    public void save(User user) {
        jdbcTemplate.update(
                insertUserSql,
                new Object[]{
                        user.getUsername(),
                        user.getPassword(),
                        user.getName(),
                        user.getAvatar(),
                        user.getRemember_token(),
                        user.getCreated_at(),
                        user.getUpdated_at()},
                new int[]{
                        Types.VARCHAR,
                        Types.VARCHAR,
                        Types.VARCHAR,
                        Types.VARCHAR,
                        Types.VARCHAR,
                        Types.TIMESTAMP,
                        Types.TIMESTAMP}
        );

    }

    public List<User> getUsers() {
        return jdbcTemplate.query(selectAllUserSql, new UserRowMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
