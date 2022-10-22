package com.glxt.service;


import com.glxt.mapper.UserMapper;
import com.glxt.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserBean> findall() {
        return userMapper.findAll();
    }

    @Override
    public UserBean login(String userName, String userPass) {
        return userMapper.login(userName, userPass);
    }

    @Override
    public int register(UserBean users) {
        return userMapper.register(users);
    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public UserBean findByid(int id) {
        return userMapper.findByid(id);
    }

    @Override
    public int updateUser(UserBean users) {
        return userMapper.updateUser(users);
    }

    @Override
    public UserBean findByuser(String userName) {
        return userMapper.findByName(userName);
    }

}
