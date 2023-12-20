package com.java.springboot.web.web.DAO;



import com.java.springboot.web.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void updateUser(int id,User upUser);
}
