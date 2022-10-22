package com.glxt.mapper;

import com.glxt.model.UserBean;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    List<UserBean> findAll();

    UserBean login(String userName, String userPass);

    int register(UserBean users);

    int delUser(int id);

    UserBean findByid(int id);

    int updateUser(UserBean users);

    UserBean findByName(String userName);

}
