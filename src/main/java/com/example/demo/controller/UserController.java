package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.service.JobService;
import com.example.demo.service.ResumeService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;


    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/")
    String we(){

        return "login";
    }

    @RequestMapping("/login")
    String login(User user,HttpSession session){
        boolean flag=userService.login(user);
        if (flag) {
            user=userService.findByName(user.getUsername());
            System.out.println("user"+user);
            session.setAttribute("user",user);
            return "index";
        }else {
            return "login";
        }
    }

    @RequestMapping("/regist")
    String regist(User user){
        System.out.println(user);
        user.setRole_id("1");
        boolean flag=userService.regist(user);
        if (flag) {

            return "index";
        }else {
            return "login";
        }
    }

    @RequestMapping("/index")
    String index(){
        return "index";
    }

    @RequestMapping("/addresume")
    String insert(HttpSession session){
        List<Job> jobs=jobService.findAll();
        session.setAttribute("jobs",jobs);
        User user = (User) session.getAttribute("user");
        Resume resume=resumeService.findByUserId(user.getId());
        session.setAttribute("resume",resume);

        return "resume";
    }
    @RequestMapping("/add")
    String add(@RequestParam("user_id") Integer user_id, Resume resume){
        System.out.println(resume);
        resume.getUser().setId(user_id);
        System.out.println(resume);
        if(resumeService.findByUserId(user_id)==null) {
            resumeService.insert(resume);
        }else{
            resumeService.update(resume);
        }

        return "index";
    }

    @RequestMapping("/user")
    String user(){
        return "user";
    }

}

