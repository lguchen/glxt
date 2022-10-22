package com.glxt.mapper;

import com.glxt.model.UserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface CommentMapper {
    @Select("select * from tbluser where id = #{id}")
    public UserBean findbyId(Integer id);

    @Insert({"insert into tbluser(userName,userPass,userRole) values(#{userName},#{userPass},#{userRole})"})
    public void insert(String userName, String userPass, String userRole);

    @Delete("delete from tbluser where id=#{id}")
    public void delete(Integer id);

    @Update("update tbluser set userName=#{userName},userPass=#{userPass},userRole=#{userRole} where id=#{id}")
    public void update(String userName, String userPass,String userRole,Integer id);
}
