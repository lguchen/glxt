package com.glxt.mapper;

import com.glxt.model.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    List<UserBean> findAll();

    UserBean login( @Param("userName")String userName, @Param("userPass")String userPass);

    int register(UserBean users);

    int delUser(int id);

    UserBean findByid(int id);

    int updateUser(UserBean users);

    UserBean findByName(String userName);

}
