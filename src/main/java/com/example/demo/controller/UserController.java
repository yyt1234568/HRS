package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private Interview_infoService interview_infoService;






    @RequestMapping("/")
    String we(){

        return "login";
    }

    @RequestMapping("/login")
    String login(User user,HttpSession session){
        boolean flag=userService.login(user);
        if (flag) {
            user=userService.findByName(user.getUsername());
            session.setAttribute("user",user);
            if (user.getRole_id().equals("1")) {
                return "index";
            }else if (user.getRole_id().equals("2")){

                return "redirect:/employee/info";
            }else {
                return "manager";
            }
        }else {
            return "login";
        }
    }

    @RequestMapping("/regist")
    String regist(User user){
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
        resume.getUser().setId(user_id);
        if(resumeService.findByUserId(user_id)==null) {
            resumeService.insert(resume);
        }else{
            resumeService.update(resume);
        }

        return "index";
    }

    @RequestMapping("/recruit")
    String recruit(Model model,HttpSession session){
        List<Recruit> recruits = recruitService.findAll();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        Resume resume=resumeService.findByUserId(user.getId());
        model.addAttribute("recruits",recruits);
        model.addAttribute("resume",resume);
        return "data";
    }


    @RequestMapping("/showrecruit")
    String showrecruit(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Interview_info> interviewInfos = interview_infoService.findAll();
        List<Interview_info> interview_infos=new ArrayList<>();
        for (int i=0;i<interviewInfos.size();i++){
            System.out.println("userId"+interviewInfos.get(i).getResume().getUser().getId());
            if (interviewInfos.get(i).getResume().getUser().getId()==user.getId()){
                interview_infos.add(interviewInfos.get(i));
            }
        }
        session.setAttribute("interview_infos",interview_infos);
        return "showrecruit";
    }

    @RequestMapping("/deliver")
    String deliver(Integer recruit_id,Integer resume_id,HttpSession session){
        User user= (User) session.getAttribute("user");
        Resume resume = resumeService.findById(resume_id);
        Recruit recruit = recruitService.findById(resume_id);
        Interview interview=new Interview(-1,user.getUsername(),new Date(),0,0,resume,recruit);
        interviewService.insert(interview);

        return "redirect:/user/index";
    }

    @RequestMapping("/user")
    String user(){
        return "user";
    }

}

