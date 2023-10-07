package com.lilichatians.Lilichatians.user.service;

import com.lilichatians.Lilichatians.common.User;
import com.lilichatians.Lilichatians.common.UserDetails;
import com.lilichatians.Lilichatians.common.service.EmailService;
import com.lilichatians.Lilichatians.user.dao.UserDao;
import com.lilichatians.Lilichatians.user.dao.UserDetailsDao;
import com.lilichatians.Lilichatians.user.dto.UserSignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailsDao userDetailsDao;
    public Boolean sendMail(String recipient, String message, String subject) {
        return emailService.sendSimpleMail(recipient, message, subject);
    }

    public Boolean registerUser(UserSignupDto userSignupDto) {
        try {
            Random random = new Random();
            Integer randomNumber = random.nextInt(99999) + random.nextInt(1, 9) * 100000;
            String[] name = userSignupDto.getName().split(" ");
            String message = "\n Hi " + name[0] + ",\n \n" +
                    "We just need to verify your email address before you can access Lilichatians App.\n" +
                    "\n Your Verification Code is " + randomNumber + " \n \n" +
                    "Thanks!";

            User user = new User();
            user.setCode(randomNumber+"");
            user.setEmail(userSignupDto.getEmail());
            user.setPassword(userSignupDto.getPassword());
            userDao.save(user);
            UserDetails userDetails = new UserDetails();
            userDetails.setUser(user);
            userDetails.setName(userSignupDto.getName());
            userDetailsDao.save(userDetails);
            sendMail(userSignupDto.getEmail(), message, "Confirm Your Identity");

            return Boolean.TRUE;
        } catch ( Exception e ) {
            return Boolean.FALSE;
        }
    }

    public Boolean verificationOfUser(UserSignupDto userSignupDto) {
        User user = userDao.fetchByEmailPasswordCode(userSignupDto.getEmail(), userSignupDto.getPassword(), userSignupDto.getCode());
        if(user == null)
            return Boolean.FALSE;
        user.setIsActive(Boolean.TRUE);
        userDao.save(user);
        return Boolean.TRUE;
    }

}
