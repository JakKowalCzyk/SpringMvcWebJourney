package com.kowal.service;

import com.kowal.User;
import com.kowal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2016-01-13.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUser(Long id){
        return userDao.findUSer(id);
    }

    public void saveUser(User user){
        userDao.persist(user);
        userDao.flush();
    }

    public User loginUser(Long userId, String password){
        User user = this.findUser(userId);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
