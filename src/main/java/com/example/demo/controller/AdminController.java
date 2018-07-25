package com.example.demo.controller;

import com.example.demo.entity.Interview;
import com.example.demo.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InterviewService interviewService;

    @RequestMapping("/manager")
    public String manager(HttpSession session){
        List<Interview> interviews = interviewService.findAll();
        System.out.println(interviews);
        session.setAttribute("interviews",interviews);
        return "manager";
    }


}
