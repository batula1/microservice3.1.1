package com.java.springboot.web.web.service;

import com.java.springboot.web.web.DAO.UserDao;
import com.java.springboot.web.web.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service

public class userServiceImp implements UserService {


    private final UserDao userDao;

    @Autowired
    public userServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User upUser) {
        userDao.updateUser(id, upUser);
    }


}
