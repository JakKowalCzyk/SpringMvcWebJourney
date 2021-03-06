package com.kowal.dao;

import com.kowal.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by JK on 2016-01-13.
 */
@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final String selectUser = "SELECT o FROM User AS o where o.name = :name";

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

    public TypedQuery<User> findUserByName(String name) {
        if(name == null || name.length()==0) throw new IllegalArgumentException("The name argument is required");
        try{
            TypedQuery<User> query = entityManager.createQuery(selectUser, User.class);
            query.setParameter("name", name);
            return query;
        }catch (NoResultException no){
            return null;
        }
    }
}
