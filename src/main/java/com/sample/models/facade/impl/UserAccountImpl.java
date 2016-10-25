package com.sample.models.facade.impl;

import com.sample.models.facade.UserAccountFacade;
import com.sample.models.model.UserAccount;
import com.sample.models.model.UserAccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ganeshramiyer on 10/23/16.
 */
@Service
public class UserAccountImpl implements UserAccountFacade{

    private static final Logger logger = Logger.getLogger(UserAccountFacade.class);

    @Autowired
    private UserAccountRepository userAccountRepo;

    public void addTestUser(){
        logger.info("Adding test user");
        UserAccount user = new UserAccount();
        user.setId();
        user.setEmail("First");
        user.setPassword("Test");
        userAccountRepo.save(user);
        return;
    }

    public void addUser(String firstname,String lastname,String email,String school,String department,String password) {
        UserAccount user = new UserAccount(firstname,lastname,email,school,department,password);
        user.setId();
        userAccountRepo.save(user);
        return;
    }

    public boolean checkCredentials(String email, String password) {
        if (userAccountRepo.findByEmailAndPassword(email, password).size() == 1) {
            return true;
        } else {
            return false;
        }
    }

}