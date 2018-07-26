package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private Interview_infoService interview_infoService;
    @Autowired
    private JobService  jobService;
    @Autowired
    private ResumeService  resumeService;
    @Autowired
    private UserService  userService;


    @RequestMapping("/manager")
    public String manager(HttpSession session) {
        List<Interview> interviews = interviewService.findAll();
        System.out.println(interviews);
        session.setAttribute("interviews", interviews);
        return "manager";
    }

    @RequestMapping("readresume")
    public String readresume(Integer id, Model model) {
        Interview interview = interviewService.findById(id);
        interview.setLookStatus(1);
        interviewService.update(interview);
        System.out.println(interview);
        model.addAttribute("interview",interview);
        model.addAttribute("resume", interview.getResume());
        model.addAttribute("recruit", interview.getRecruit());
        return "showresume";
    }


    @RequestMapping("deleteresume")
    public String deleteresume(Integer id, Model model) {
        interviewService.delete(id);
        return "redirect:/admin/manager";
    }


    @RequestMapping("interview")
    public String interview(Integer interview_id,Integer resume_id,String viewtime,Interview_info interview_info) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        interview_info.setView_time(sdf.parse(viewtime));
        interview_info.getResume().setId(resume_id);
        interview_info.getInterview().setId(interview_id);
        interview_infoService.insert(interview_info);
        Interview interview = interviewService.findById(interview_id);
        interview.setInterviewStatus(1);
        interviewService.update(interview);
        return "redirect:/admin/manager";
    }

    @RequestMapping(value = "addwork")
    public String addwork(Model model){
        List<Dept> depts = deptService.findAll();

        model.addAttribute("depts",depts);
        return "addwork";
    }

    @RequestMapping("addrecruit")
    public String addrecruit(Recruit recruit,Integer dept_id,Integer job_id){
        System.out.println(recruit);
        recruit.getDept().setId(dept_id);
        recruit.getJob().setId(job_id);
        recruitService.insert(recruit);
        return "redirect:/admin/manager";
    }

    @RequestMapping(value = "getJob",method=RequestMethod.POST)
    @ResponseBody
    public List<Job> getJob(Integer dept_id){
        List<Job> jobs=jobService.findByDeptId(dept_id);

        return  jobs;
    }

    @RequestMapping("audition")
    public String audition(Model model){
        List<Interview_info> interviewInfos = interview_infoService.findAll();
        model.addAttribute("interviewInfos",interviewInfos);
        return "audition";
    }
    @RequestMapping("readaudition")
    public String readaudition(Integer id,Model model){
        Interview interview = interviewService.findById(id);

        model.addAttribute("interview",interview);
        model.addAttribute("resume", interview.getResume());
        model.addAttribute("recruit", interview.getRecruit());
        return "recruit";
    }

    @RequestMapping("recruit")
    public String recruit(Resume resume,Model model){
        System.out.println(resume);
        Resume resume1 = resumeService.findById(resume.getId());
        User user = userService.findById(resume1.getUser().getId());
        user.setRole_id("2");
        userService.update(user);



        return "redirect:/admin/manager";
    }

}
