package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private UserService  userService;
    @Autowired
    private EmployeeService  employeeService;
    @Autowired
    private TrainService  trainService;
    @Autowired
    private SalaryService  salaryService;
    @Autowired
    private SignService  signService;


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


    @RequestMapping("deptinfo")
    public String deptinfo(Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return "adminDeftInfo";
    }

    @RequestMapping("deletedept")
    public String deletedept(Integer id){
        if (id!=null){
            deptService.delete(id);

        }
        return "redirect:/admin/deptInfo";
    }

    @RequestMapping("adddept")
    public String adddept(Integer id,Model model){
        if (id!=null){
            Dept dept=deptService.findById(id);
            model.addAttribute("dept",dept);
        }
        return "adminDeftUpdate";
    }


    @RequestMapping("addOrUpdate")
    public String addOrUpdate(Integer id,String name){
        System.out.println(id+","+name);
        Dept dept=new Dept();
        dept.setName(name);
        if (id!=null){
            dept.setId(id);
           deptService.update(dept);
        }else {
            dept.setCreateDate(new Date());
            deptService.insert(dept);
        }
        return "redirect:/admin/deptInfo";
    }



    /*职位信息*/

    @RequestMapping("jobinfo")
    public String jobinfo(Model model){
        List<Dept> depts =deptService.findAll();
        model.addAttribute("depts",depts);
        return "adminJobInfo";
    }

    @RequestMapping("deletejob")
    public String deletejob(Integer id){
        if (id!=null){
            jobService.delete(id);

        }
        return "adminJobInfo";
    }

    @RequestMapping("addjob")
    public String addjob(Integer id,Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        if (id!=null){
            Job job=jobService.findById(id);
            model.addAttribute("job",job);
        }
        return "adminJobUpdate";
    }


    @RequestMapping("addOrUpdateJob")
    public String addOrUpdateJob(Integer dept_id,Job job, BindingResult bindingResult){
        job.getDept().setId(dept_id);
        System.out.println(job);
        if (job.getId()!=0){
            jobService.update(job);
        }else {
            jobService.insert(job);
        }
        return "redirect:/admin/jobinfo";
    }

    @RequestMapping(value = "deptdata",method=RequestMethod.POST)
    @ResponseBody
    public Job employeedata(Model model,Integer job_id) {
       Job job=jobService.findById(job_id);
       model.addAttribute("job",job);
        return  job;
    }


    @RequestMapping("employees")
    public String employees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "adminEmployeeInfo";
    }


    @RequestMapping("updateemployee")
    public String updateemployee(Integer id,Model model){
        Employee employee=employeeService.findById(id);
        System.out.println(employee);
        model.addAttribute("employee",employee);
        return "adminEmployeeUpdate";
    }

    @RequestMapping("adminUpdateEmployee")
    public String adminUpdateEmployee(Integer dept,Integer job,Employee employee, BindingResult bindingResult){
        employee.getJob().setId(job);
        employee.getDept().setId(dept);
        System.out.println(employee);
        employeeService.updateAll(employee);
        return "redirect:/admin/employees";
    }

    @RequestMapping("deleteemployee")
    public String deleteemployee(Integer id){
        employeeService.delete(id);
        return "redirect:/admin/employees";
    }


    //培训信息
    @RequestMapping("trains")
    public String trains(Model model){
        List<Train> trains = trainService.findAll();
        System.out.println(trains);
        model.addAttribute("trains",trains);
        return "adminTrainInfo";
    }

    @RequestMapping("updatetrain")
    public String updatetrain(Integer id,Model model){
        Train train = trainService.findById(id);
        System.out.println(train);
        model.addAttribute("train",train);
        return "adminTrainUpdate";
    }

    @RequestMapping("adminUpdateTrain")
    public String adminUpdateTrain(Integer employee_id,Train train, BindingResult bindingResult){
        train.getEmployee().setId(employee_id);
        System.out.println(train);
        trainService.update(train);
        return "redirect:/admin/trains";
    }

    @RequestMapping("deletetrain")
    public String deletetrain(Integer id){
        trainService.delete(id);
        return "redirect:/admin/trains";
    }

    /**
     * 奖惩信息
     * @param model
     * @return
     */
    @RequestMapping("salaries")
    String rewards(Model model){

        List<Salary> salaries = salaryService.findAll();
        System.out.println(salaries);
        model.addAttribute("salaries",salaries);
        return "adminSalaries";
    }

    @RequestMapping("updatesalary")
    public String updatesalary(Integer id,Model model){
        Salary salary = salaryService.findById(id);
        System.out.println(salary);
        model.addAttribute("salary",salary);
        return "adminSalaryUpdate";
    }

    @RequestMapping("adminUpdateSalary")
    public String adminUpdateSalary(Integer employee_id,Salary salary, BindingResult bindingResult){
        salary.getEmployee().setId(employee_id);
        System.out.println(salary);
        salaryService.update(salary);
        return "redirect:/admin/salaries";
    }

    @RequestMapping("deletesalary")
    public String deletesalary(Integer id){
        salaryService.delete(id);
        return "redirect:/admin/salaries";
    }

    @RequestMapping("payroll")
    public String payroll(Model model){
        List<Sign> signs = signService.findAll();
        List<Sign> signs_backup=new ArrayList<>();
        Map<Employee,Double> payRolls=new HashMap<>();
        for (int i = 0; i <signs.size() ; i++) {
            Sign sign=signs.get(i);
            if(sign.getStatus()==1&&sign.getGiven_status()==0){
                Employee employee=employeeService.findByName(sign.getUser().getUsername());
                System.out.println(employee);
                signs_backup.add(sign);
                if(!payRolls.containsKey(employee)){
                    payRolls.put(employee,200.0);
                }else{
                    payRolls.put(employee,200.0+payRolls.get(employee));

                }
            }
        }
        System.out.println(payRolls);
        model.addAttribute("signs",signs);
        model.addAttribute("payRolls",payRolls);
        return "adminPayRoll";
    }

    @RequestMapping("givesalary")
    public String givesalary(HttpSession session,Integer id){
        User user= (User) session.getAttribute("user");
        List<Sign> signs=signService.findSalary();
        Employee employee = employeeService.findById(id);
        for (int i = 0; i <signs.size() ; i++) {
            Sign sign = signs.get(i);
            if (sign.getUser().getUsername().equals(employee.getName())){
                sign.setGiven_status(1);
                signService.update(sign);
            }
        }
        return "redirect:/admin/payroll";
    }


}
