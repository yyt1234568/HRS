package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    String index(HttpSession session){
        List<User> users=userService.findAll();
        for (User user:
             users) {
            System.out.println(user);
        }
        session.setAttribute("users",users);
        return "index";
    }

    @RequestMapping("/insert")
    String insert(){
        User user=new User(-1,"杨玉涛");
        userService.insert(user);
        List<User> users=userService.findAll();
        for (User user1:
                users) {
            System.out.println(user1);
        }
        return "hello";
    }

}

