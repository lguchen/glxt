
package com.glxt.controller;

import com.glxt.model.UserBean;
import com.glxt.service.UserService;
import com.glxt.utils.MD5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    //    @PostMapping("/goregister")
//    public void goregister(@RequestParam("name")String uname,@RequestParam("password")String upass){
//        System.out.println("name:"+uname+",password:"+upass);
//    }

    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/goregister")
    public int goregister(UserBean users, @Param("userName") String name, @RequestParam("name") String uname, @RequestParam("password") String upass) {
//        System.out.println("name:" + uname + ",password:" + upass);
        String pass= MD5Utils.inputPassToFormPass(upass);//密码加密操作
        UserBean User = userServiceImpl.findByuser(name);
        if (User != null) {
            return 0;
        }
        //可加else可不加
        users.setUserName(uname);
        users.setUserPass(pass);
        users.setUserRole("普通用户");
        userServiceImpl.register(users);
        return 1;

    }
}
