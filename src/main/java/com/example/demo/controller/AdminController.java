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
import java.util.Date;
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
    @Autowired
    private EmployeeService  employeeService;


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
        Interview_info interviewInfo=interview_infoService.findByInterviewId(id);
        model.addAttribute("interview",interview);
        model.addAttribute("resume", interview.getResume());
        model.addAttribute("recruit", interview.getRecruit());
        return "recruit";
    }

    @RequestMapping("recruit")
    public String recruit(Integer interview_id,Resume resume,Model model){
        Interview_info interviewInfo = interview_infoService.findByInterviewId(interview_id);
        Resume resume1 = interviewInfo.getResume();
        User user = userService.findById(resume1.getUser().getId());
        user.setRole_id("2");
        userService.update(user);
        Recruit recruit = interviewInfo.getInterview().getRecruit();
        Employee employee=new Employee(-1,recruit.getDept() ,recruit.getJob(),
                resume1.getName(),interviewInfo.getAddress(),resume1.getPhone(),resume1.getEmail(),
                resume1.getSex(),null,null,new Date(),recruit.getSalary());

        employeeService.insert(employee);

        interview_infoService.delete(interviewInfo.getId());
        interviewService.delete(interview_id);
        recruit.setCount(recruit.getCount()-1);
        recruitService.update(recruit);

        return "redirect:/admin/manager";
    }


    @RequestMapping("deleterecruit")
    public String deleterecruit(Integer interview_id,Resume resume,Model model){
        Interview_info interviewInfo = interview_infoService.findByInterviewId(interview_id);
        interview_infoService.delete(interviewInfo.getId());
        interviewService.delete(interview_id);


        return "redirect:/admin/manager";
    }

}
