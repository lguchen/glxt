
package com.glxt.controller;

import com.glxt.model.UserBean;
import com.glxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    //    @PostMapping("/goregister")
//    public void goregister(@RequestParam("name")String uname,@RequestParam("password")String upass){
//        System.out.println("name:"+uname+",password:"+upass);
//    }

    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/goregister")
    public int goregister(UserBean users, @RequestParam("name") String uname, @RequestParam("password") String upass) {
        System.out.println("name:" + uname + ",password:" + upass);
        users.setUserName(uname);
        users.setUserPass(upass);
        users.setUserRole("普通用户");

        userServiceImpl.register(users);
        return 1;
    }

}
