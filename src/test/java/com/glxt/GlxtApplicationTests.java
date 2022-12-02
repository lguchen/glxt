package com.glxt;

import com.glxt.mapper.CommentMapper;
import com.glxt.model.UserBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GlxtApplicationTests {
    //    @Test
    //数据库连接测试
//    @Autowired
//    DataSource datasource;
//    @Test
//    public void Dbtest() {
//        Connection conn = null;
//        try {
//            conn = datasource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException("连接失败！！！");
//        }
//        System.out.println(conn);
//    }
    @Resource
    JdbcTemplate jdbcTemplate;

    //
//
//    @Autowired
    @Test
//查询全部
    public void Temptest() {

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select  * from tbluser");
        System.out.println(list);
    }

    //查找数据
    @Test
    public void TempQuery() {
        String sql = "select id,userName,userPass,userRole from tbluser where id=?";
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        UserBean user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(user);
    }

    //插入数据
    @Test
    public void TempInsert() {
        String sql = "insert into tbluser(userName,userPass,userRole) values('qdaw','ss','管理员')";
        jdbcTemplate.update(sql);
        System.out.println("写入成功");
    }

    // 删除数据
    @Test
    public void TempDelete() {
        String sql = "delete from tbluser where userName='qdaw'";
        jdbcTemplate.update(sql);
        System.out.println("删除成功");
    }

    //修改数据
    @Test
    public void TempUpdate() {
        String sql = "update tbluser set userPass='999' where  userName='a'";
        jdbcTemplate.update(sql);
        System.out.println("修改成功");
    }

    @Autowired
    private CommentMapper commentMapper;

//    查询数据

/*
    @Test
    public void selectComment(){
        UserBean user = commentMapper.findbyId(1);
        System.out.println(user);
    }
*/


//    插入(增加)数据
/*    @Test
    public void insertComment() {
        commentMapper.insert("a", "a", "普通用户");
        System.out.println("写入成功！");
    }*/


//    删除数据
/*    @Test
    public void deleteComment(){
        commentMapper.delete(8);
        System.out.println("删除成功！");
    }*/

//    更新、修改数据
/*    @Test
    public void updateComment() {
        commentMapper.update("b","ab","普通用户",2);
        System.out.println("修改成功！");
    }*/

    void contextLoads() {
    }

}
