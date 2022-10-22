package com.glxt.controller.dbtests;

import com.glxt.model.JPABean;
import com.glxt.repository.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class JPAController {
    @Autowired
    JPARepository rep;

    /*查询所有数据*/
    @ResponseBody
    @GetMapping("/JPA_All")
    public List<JPABean> JPA_All(Model m) {
        List<JPABean> UserList = rep.findAll();
        m.addAttribute("Result", UserList);
        return UserList;
    }

    /*按id查找数据*/
    @ResponseBody
    @GetMapping("/JPA_fbID/{id}")
    public Optional<JPABean> fbID(@PathVariable int id, Model m) {
        Optional<JPABean> UserList = rep.findById(id);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    /*按用户名字段查询*/
    @ResponseBody
    @GetMapping("/JPA_fbn/{name}")
    public List<JPABean> fbn(@PathVariable String name) {
        return (List<JPABean>) rep.findByUserName(name);
    }

    /*按用户角色字段查询*/
    @ResponseBody
    @GetMapping("/JPA_Role/{role}")
    public List<JPABean> JPA_Role(@PathVariable String role, Model m) {
        List<JPABean> UserList = rep.findByUserRole(role);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    /*使用@query进行复杂查询*/
    @GetMapping("/JPA_lbn/{name}")
    public String lbn(@PathVariable String name, Model m) {
        List<JPABean> UserList = rep.listByName(name);
        m.addAttribute("Result", UserList);
        return "result";
    }

    /*JPA的JpaRepository方式插入数据*/
    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Insert")
    public String JPAInsert() {
        rep.JPAInsert("bb", "d", "普通用户");
        return "写入成功！";
    }

    /*JPA的JpaRepository方式删除数据*/
    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Delete/{name}")
    public String JPADelete(@PathVariable String name) {
        rep.JPADelete(name);
        return "删除成功！";
    }

    /*JPA的JpaRepository方式更新修改数据*/

    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Update/{name}&{name1}")
    public String JPAUpdate(@PathVariable String name, @PathVariable String name1) {
        rep.JPAUpdate(name1, name);
        return "修改成功！";
    }

    /*JPA的JpaRepository方式example查询数据*/
    @ResponseBody
    @GetMapping("/JPA_Example/{name}")
    public List<JPABean> JPA_Example(Model m,@PathVariable String name) {
        JPABean user = new JPABean();
//        user.setUserName("b");
        user.setUserName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<JPABean> example = Example.of(user, matcher);
        List<JPABean> UserList = rep.findAll(example);
        m.addAttribute("Result", UserList);
        return UserList;
    }
}
