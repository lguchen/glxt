package com.glxt.service;

import com.glxt.model.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface UserService {

    public List<UserBean> findall();

    public UserBean login(String userName, String userPass);

    public int register(UserBean users);

    public int delUser(int id);

    public UserBean findByid(int id);

    public int updateUser(UserBean users);

    public UserBean findByuser(String userName);
}

