package spring;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        return new User(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("name"),
                resultSet.getString("avatar"),
                resultSet.getString("remember_token"),
                resultSet.getDate("created_at"),
                resultSet.getDate("updated_at")
        );
    }
}
