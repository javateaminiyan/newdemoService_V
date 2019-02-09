package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.LoginDao;
import com.smw.velloredemo.exception.UserAlreadyExistsException;
import com.smw.velloredemo.repository.LoginRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements ILogin {

    private final LoginRepo loginRepo;

    @Autowired
    public LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    public LoginDao insertUser(LoginDao user) {


        return loginRepo.save(user);
    }

    @Override
    public Optional<LoginDao> findbyId(String id) {
        if (id.matches("[0-9]+") && id.length() == 4) {
            //  if(loginRepo.findById(Long.parseLong(id)).isPresent())
            return loginRepo.findById(Long.parseLong(id));
        }
        else if (loginRepo.findbyUsername(id).isPresent())
            return loginRepo.findbyUsername(id);
        else
            return loginRepo.findbyMobileno(id);

        // No Record Found
    }

    @Override
    public Optional<LoginDao> findbyUsername(String username) {
        return loginRepo.findbyUsername(username);
    }

    @Override
    public Optional<LoginDao> findbyMobileno(String mobileno) {
        return loginRepo.findbyMobileno(mobileno);
    }

    @Override
    public Object findRoles(int id) {
        return loginRepo.findRoles(id);
        //  return null;
    }

    @Override
    public String updatePassword(Integer id, String password) {

        if (loginRepo.findUserid(id).isPresent()) {

            loginRepo.updatePassword(password, id);

            return "Updated Successfully Password";
        }

        return "Failed Update Password";
    }

    @Override
    public String updateFirebaseToken(Integer id, String firebaseid) {
        if (loginRepo.findUserid(id).isPresent()) {

            loginRepo.updateFirebaseToken(firebaseid, id);

            return "Updated Successfully Token";
        }

        return "Failed Update Token";
    }

    @Override
    public List<LoginDao> checkalreadyTokenPresent(String firebaseid) {
       return loginRepo.checkalreadyTokenPresent(firebaseid);

    }
}
