package com.glxt.controller;

import com.glxt.model.UserBean;
import com.glxt.service.UserService;
import com.glxt.utils.MD5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/gologin")
    public String gologin(@RequestParam("name") String username, @RequestParam("password") String userpass, HttpSession session) {
//        if ("admin".equals(username) && "123".equals(userpass)) //用于测试
        String password2= MD5Utils.inputPassToFormPass(userpass);//验证加密操作
        if (userServiceImpl.login(username, password2) != null) {
//            return "登录成功";
            session.setAttribute("currentuser", username);
            return "index";
        } else {
//       return "用户名或密码输入有误请重新输入！";
            return "error";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("currentuser");
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "/login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/publicpage")
    public String publicpage() {
        return "publicpage";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/edituser")
    public String edituser(Model m) {
        List<UserBean> UserList = (List<UserBean>) userServiceImpl.findall();
        m.addAttribute("Result", UserList);
        return "edituser";
    }

    @GetMapping("/godel/{id}") //删除
    public String delUser(@PathVariable int id) {
        userServiceImpl.delUser(id);
        return "redirect:/edituser";
    }


    @GetMapping("/goupdate/{id}") //跳转修改页面

    public String goupdate(@PathVariable int id, Model model) {
        UserBean user = userServiceImpl.findByid(id);
        model.addAttribute("user", user);
        return "updateuser";
    }


    @GetMapping("/update") //修改
    public String update(UserBean users, @RequestParam("id") int id, @RequestParam("name") String uname, @RequestParam("pass") String upass, @RequestParam("role") String urole) {
        users.setId(id);
        users.setUserName(uname);
        users.setUserPass(upass);
        users.setUserRole(urole);
        userServiceImpl.updateUser(users);
        return "redirect:/edituser";
    }

    @GetMapping("/gofind")
    public String gofind() {
        return "findUser";
    }

    @GetMapping("/find")
    public String find(Model m, @Param("userName") String name) {
        UserBean User = userServiceImpl.findByuser(name);
        m.addAttribute("Result", User);
        return "edituser";
    }
}

