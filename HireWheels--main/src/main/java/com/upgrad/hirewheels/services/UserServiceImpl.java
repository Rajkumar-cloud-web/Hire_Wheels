package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;
    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        if (userDao.findByEmail(user.getEmail())!=null) {
            throw new UserAlreadyExistsException("Email Already Exists");
        }
        if (userDao.findByMobileNo(user.getMobileNo())!=null){
            throw  new UserAlreadyExistsException("Mobile Number Already Exists");
        }
        return userDao.save(user);
    }

    @Override
    public User getUser(String emailId, String password) throws Exception {
        if(userDao.findByEmail(emailId)==null){
            throw  new Exception("User not Registered");
        }
        User user = userDao.findByEmail(emailId);
        if(!user.getPassword().equals(password)){
            throw new Exception("Unauthorized User");
        }
        return userDao.findByEmail(emailId);
    }

    @Override
    public User getUserByID(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id).get();
    }
}
