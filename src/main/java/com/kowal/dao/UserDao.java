package com.kowal.dao;

import com.kowal.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by JK on 2016-01-13.
 */
@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public User findUSer(Long id){
        if(id==null) return null;
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void persist(User user){
        getEntityManager().persist(user);
    }

    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public void clear() {
        this.entityManager.clear();
    }
}
