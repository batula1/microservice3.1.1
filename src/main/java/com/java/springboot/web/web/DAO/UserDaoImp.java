package com.java.springboot.web.web.DAO;

import com.java.springboot.web.web.model.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override

    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();

    }

    @Override
    public void saveUser(User user) {

            entityManager.persist(user);

    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void updateUser(int id,User upUser){
        User user = getUser(id);
        if(user != null){
            user.setName(upUser.getName());
            user.setLastname(upUser.getLastname());
            user.setAge(upUser.getAge());
        }
        entityManager.merge(user);

    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();

    }

}