package com.glxt.controller.dbtests;

import com.glxt.model.UserBean;
import com.glxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author luo
 * @date 2022年9月25日 18:42
 */
@Controller
public class MybatisController {
    @Autowired
    private UserService userServiceImpl;

    @ResponseBody
    @GetMapping("/Mybat_All")
    public List<UserBean> Mybat_All(Model m) {
        List<UserBean> UserList = userServiceImpl.findall();
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @GetMapping("/Mybat_All_Page")
    public String Mybat_All_Page(Model m){
        List<UserBean> UserList=userServiceImpl.findall();
        m.addAttribute("Result",UserList);
        return "result";
    }

}