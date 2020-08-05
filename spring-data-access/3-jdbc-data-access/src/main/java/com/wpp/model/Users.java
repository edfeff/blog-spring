package com.wpp.model;

import java.util.Date;

/**
 * -- auto-generated definition
 * create table users
 * (
 * id        int auto_increment
 * primary key,
 * firstName varchar(255) null,
 * lastName  varchar(255) null,
 * createdAt datetime     not null,
 * updatedAt datetime     not null
 * );
 * <p>
 * INSERT INTO example.users (id, firstName, lastName, createdAt, updatedAt) VALUES (1, 'John0', 'Hancock0', '2020-07-03 03:13:46', '2020-07-03 03:13:46');
 */
public class Users {
    Integer id;
    String firstName;
    String lastName;
    Date createdAt;
    Date updatedAt;

    public Users() {
    }

    public Users(String firstName, String lastName, Date createdAt, Date updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Users(Integer id, String firstName, String lastName, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
