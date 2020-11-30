package spring;

import java.util.Date;

/**
 * -- auto-generated definition
 * create table goadmin_users
 * (
 * id             int unsigned auto_increment
 * primary key,
 * username       varchar(100)                           not null,
 * password       varchar(100) default ''                not null,
 * name           varchar(100)                           not null,
 * avatar         varchar(255)                           null,
 * remember_token varchar(100)                           null,
 * created_at     timestamp    default CURRENT_TIMESTAMP null,
 * updated_at     timestamp    default CURRENT_TIMESTAMP null,
 * constraint admin_users_username_unique
 * unique (username)
 * )
 * collate = utf8mb4_unicode_ci;
 */
public class User {
    private Integer id;//int unsigned auto_increment
    private String username;//varchar(100)                           not null,
    private String password;//varchar(100) default ''                not null,
    private String name;//varchar(100)                           not null,
    private String avatar;//varchar(255)                           null,
    private String remember_token;//varchar(100)                           null,
    private Date created_at;//timestamp    default CURRENT_TIMESTAMP null,
    private Date updated_at;//timestamp    default CURRENT_TIMESTAMP null,

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String name, String avatar, String remember_token, Date created_at, Date updated_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.remember_token = remember_token;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", remember_token='" + remember_token + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
