package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    public BookingDao bookingDao;
    @Autowired
    public UserDao userDao;
    @Override
    public Booking addBooking(Booking booking, User user) throws Exception {
        if(user.getWalletMoney()<booking.getAmount()){
            throw  new Exception("Insufficient Balance. Please Check With Admin");
        }
        else{
            user.setWalletMoney(user.getWalletMoney()-booking.getAmount());
            userDao.save(user);
        }
        return bookingDao.save(booking);
    }
}
