package com.java.springboot.web.web.service;



import com.java.springboot.web.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    public User getUser(int id);
    void deleteUser(int id);
    void updateUser(int id,User upUser);
}
