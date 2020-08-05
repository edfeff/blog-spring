package com.wpp.service;

import com.wpp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public void countUser() {
        System.out.println("countUser");
        System.out.println(userDao.findUserCount());
    }
}
