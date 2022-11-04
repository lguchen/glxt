package com.glxt.service;

import com.glxt.model.UserBean;
import org.apache.ibatis.annotations.Param;
import java.util.List;



public interface UserService {

    public List<UserBean> findall();

    public UserBean login(@Param("userName") String userName,@Param("userPass") String userPass);

    public int register(UserBean users);


    public int delUser(int id);

    public UserBean findByid(int id);

    public int updateUser(UserBean users);

    public UserBean findByuser(String userName);



}

