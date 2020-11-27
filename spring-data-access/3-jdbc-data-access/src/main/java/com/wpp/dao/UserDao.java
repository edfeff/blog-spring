package com.wpp.dao;

import com.wpp.model.NameParameter;
import com.wpp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier(value = "namedParameterJdbcTemplate")
    NamedParameterJdbcTemplate parameterJdbcTemplate;

    //    -------------------QUERY
    //    -------------------QUERY
    //    -------------------QUERY

    public int findUserCount() {
        return jdbcTemplate.queryForObject("select count(1) from users", Integer.class);
    }

    public int findUserCountByFirstName(String firstName) {
        firstName = firstName == null ? "" : firstName;
        return jdbcTemplate.queryForObject("select count(1) from users where firstName = ? ", Integer.class, firstName);
    }

    public int findUserCountByFirstName_params(String firstName) {
        String sql = "select count(1) from users where firstName = :firstName";
//        namedParameterJdbcTemplate.queryForObject("")
        SqlParameterSource source = new MapSqlParameterSource("firstName", firstName);
        return parameterJdbcTemplate.queryForObject(sql, source, Integer.class);
    }

    public int findUserCountByFirstName_bean_params(String firstName) {
        String sql = "select count(1) from users where firstName = :firstName";

        NameParameter parameter = new NameParameter();
        parameter.setFirstName(firstName);

        SqlParameterSource source = new BeanPropertySqlParameterSource(parameter);

        return parameterJdbcTemplate.queryForObject(sql, source, Integer.class);
    }

    public String findFirstNameById(Integer id) {
        return jdbcTemplate.queryForObject("select firstName from users where id =?", String.class, id);
    }

    public String findFirstNameById_params(Integer id) {
        String sql = "select firstName from users where id = :id";
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return parameterJdbcTemplate.queryForObject(sql, params, String.class);
    }

    public Users findByUserId(Integer id) {
        Users users = jdbcTemplate.queryForObject("select id,firstName,lastName,createdAt,updatedAt from users where id = ?", new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new Users(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("createdAt"),
                        rs.getDate("updatedAt"));
            }
        }, id);
        return users;
    }

    public List<Users> findUserListByDate(Date date) {
        return jdbcTemplate.query("select id,firstName,lastName,createdAt,updatedAt from users where createdAt > ?", new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new Users(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("createdAt"),
                        rs.getDate("updatedAt"));
            }
        }, date);
    }

    //简化写法
    RowMapper usersRowMappernew = new RowMapper<Users>() {
        @Override
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Users(rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt"));
        }
    };

    public List<Users> findUserListByDateSimple(Date date) {
        return jdbcTemplate.query("select id,firstName,lastName,createdAt,updatedAt from users where createdAt > ?", usersRowMappernew, date);
    }

    //------------------INSERT
    //------------------INSERT
    //------------------INSERT
    @Transactional
    public void insertUser(Users users) {
        jdbcTemplate.update("insert  into  users(firstName, lastName, createdAt, updatedAt) values(?,?,?,?)",
                users.getFirstName(), users.getLastName(), users.getCreatedAt(), users.getUpdatedAt());
    }

    //---------------UPDATE
    //---------------UPDATE
    //---------------UPDATE
    @Transactional
    public void updateUser(int id, Users users) {
        jdbcTemplate.update("update users set firstName=? ,lastName=?,updatedAt=? where  id = ?", users.getFirstName(), users.getLastName(), new Date(), id);
    }

    //---------------DELETE
    //---------------DELETE
    //---------------DELETE
    @Transactional
    public void deleteUserByFirstName(String firstName) {
        jdbcTemplate.update("delete from users where firstName= ?", firstName);
    }

    //----------execute
    //----------execute
    //----------execute
    public void createSampleTable(String name) {
        this.jdbcTemplate.execute(String.format("create table if not exists %s (id int,name varchar(32))", name));
    }

    public void addUserToDB(String name, String password) {
        String createUserSQL = "create user '" + name + "'@'%' identified by '" + password + "'";
        this.jdbcTemplate.execute(createUserSQL);

        String grantSQL = "grant all privileges on *.* to  '" + name + "'@'%' with grant option";
        this.jdbcTemplate.execute(grantSQL);

        this.jdbcTemplate.execute("flush privileges ");
    }

}

