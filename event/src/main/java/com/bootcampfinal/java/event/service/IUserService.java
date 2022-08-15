package com.bootcampfinal.java.event.service;

import com.bootcampfinal.java.event.web.model.UserModel;

import java.util.List;

public interface IUserService {


    UserModel login(String email , String password) throws Exception;

    List<UserModel> findAll() throws Exception;

    UserModel findById(Long id) throws Exception;

    UserModel create(UserModel userModel) throws Exception;

    void update(Long id, UserModel userModel) throws Exception;

    void deleteById(Long id) throws Exception;

}
