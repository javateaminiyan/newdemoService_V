package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.LoginDao;

import java.util.List;
import java.util.Optional;

public interface ILogin {

    LoginDao insertUser(LoginDao tenth);

    Optional<LoginDao> findbyId(String id);

    Optional<LoginDao> findbyUsername(String username);
    Optional<LoginDao> findbyMobileno(String mobileno);


    Object findRoles(int id);

     String updatePassword(Integer id, String loginDao);

    String updateFirebaseToken(Integer id, String firebaseid);

    List<LoginDao> checkalreadyTokenPresent(String firebaseid);
}
