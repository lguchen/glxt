package com.glxt.controller.dbtests;

import com.glxt.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class TemplateController {

    @Resource  /* 可用@Autowired注解，@Autowired注解爆红则用 @Resource注解*/
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/Temp_All")
    public List<Map<String, Object>> Temp_All(Model m) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tbluser");
        return list;
    }

    @GetMapping("/Temp_All_result")
    public String Temp_All_result(Model m) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tbluser");
        m.addAttribute("Result", list);
        return "result";
    }

    @GetMapping("/Temp_Bean_json")
    public List<UserBean> Temp_Bean_json(Model m) {
        String sql = "select * from tbluser";
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List<UserBean> UserList = jdbcTemplate.query(sql, rowMapper);
        return UserList;
    }
    @ResponseBody
    @GetMapping("/Temp_Bean")
    public String Temp_Bean(Model m) {
        String sql = "select * from tbluser";
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List<UserBean> UserList = jdbcTemplate.query(sql, rowMapper);
        m.addAttribute("Result", UserList);
        return "result";
    }
}
