package com.wpp.dao;

import com.wpp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    public String findFirstNameById(Integer id) {
        return jdbcTemplate.queryForObject("select firstName from users where id =?", String.class, id);
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


}

