package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    DeptService deptService;
    @Autowired
    private JobService jobService;
    @Autowired
    private SignService signService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private TrainService trainService;


    @RequestMapping("index")
    String index(){
        return "employee";
    }

    @RequestMapping("info")
    String info(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        Employee employee=employeeService.findByName(user.getUsername());
        model.addAttribute("employee",employee);
        return "employee";
    }


    @RequestMapping("updateinfo")
    String updateinfo( String birthday, Employee employee1, BindingResult bindingResult, Model model, HttpSession session) throws ParseException {
        System.out.println(employee1);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        employee1.setBirthday(sd.parse(birthday));
        System.out.println(employee1);
        employeeService.update(employee1);

        return "redirect:/employee/info";
    }

    @RequestMapping("deptinfo")
    String deptinfo(Model model) {
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return "dept_info";
    }

    @RequestMapping(value = "deptdata",method=RequestMethod.POST)
    @ResponseBody
    public List<Job> deptdata(Integer dept_id) {
        List<Job> jobs=jobService.findByDeptId(dept_id);

        return  jobs;
    }

    @RequestMapping(value = "employeedata",method=RequestMethod.POST)
    @ResponseBody
    public List<Employee> employeedata(Integer dept_id,Integer job_id) {
        List<Employee> employee=employeeService.findByDeptIdAndJobId(dept_id,job_id);
        return  employee;
    }


    @RequestMapping("sign")
    String sign(HttpSession session,Model model){
        User  user=(User) session.getAttribute("user");
        //User  user=new User(2,"yyt","123","2");
        List<Sign> signs=signService.findAll();
        System.out.println(signs);
        model.addAttribute("signs",signs);
        return "sign";
    }

    @RequestMapping("start")
    String start(HttpSession session,Model model) throws UnsupportedEncodingException {
        Date now=new Date();


        User  user=(User) session.getAttribute("user");
//        User  user=new User(2,"yyt","123","2");
        Employee employee=employeeService.findByName(user.getUsername());
        int i = employeeService.isSameStartToday(user, now);
        String message="";
        if(i==0){
            if(DateUtils.isBelong(now,"0:00","12:00")){
                if (DateUtils.isBelong(now,"7:01","9:00")){
                    message="签到成功";
                    signService.insertStart(new Sign(-1,user,now,null,0));
                    //签到成功
                }else if(DateUtils.isBelong(now,"0:00","7:00")){
                    //签到太早
                    message="签到太早了,请稍后签到!!";
                }else if (DateUtils.isBelong(now,"9:01","12:00")){
                    //迟到
                    message="迟到了,请以后不要迟到!!";
                    signService.insertStart(new Sign(-1,user,now,null,-2));
                    salaryService.insert(new Salary(-1,employee,10,new Date(),"因为迟到"));
                }else{
                    //旷工
                    message="您已旷工,将扣除当天工资";
                    signService.insertStart(new Sign(-1,user,now,null,-3));
                    salaryService.insert(new Salary(-1,employee,100,new Date(),"因为早退"));
                }
            }else {
                message="签到时间已过";
            }




        }else{
            //表示今天已经签过到
            message="今天已经签过到了";
            System.out.println(message);

        }
        message=new String(message.getBytes("gbk"),"utf-8");
        model.addAttribute("message",message);

        List<Sign> signs=signService.findAll();
        System.out.println(signs);
        model.addAttribute("signs",signs);
        return "sign";
    }
    @RequestMapping("end")
    String end(Model model,HttpSession session) throws UnsupportedEncodingException {
        Date now=new Date();


        User  user=(User) session.getAttribute("user");
//        User  user=new User(2,"yyt","123","2");
        Employee employee=employeeService.findByName(user.getUsername());
        Sign sign=signService.findByUserAndDate(user);
        int i = employeeService.isSameEndToday(user, now,"12:01","23:59");
        String message="";
        if(i==0){
            if (DateUtils.isBelong(now,"17:40","23:59")){
                signService.insertEnd(new Sign(-1,user,null,now,1+sign.getStatus()));
                message="签到成功";

                System.out.println(message);
                //签到成功
            }else if(DateUtils.isBelong(now,"14:01","17:39")){
                //签到太早
                message="您已早退";
                signService.insertEnd(new Sign(-1,user,null,now,sign.getStatus()-1));
                salaryService.insert(new Salary(-1,employee,10,new Date(),"因为早退"));
            }else if (DateUtils.isBelong(now,"12:01","13:40")){
                //旷工
                message="对不起,您已算旷工!!";
                signService.insertEnd(new Sign(-1,user,null,now,sign.getStatus()-2));
                if(sign.getStatus()==0) {
                    salaryService.insert(new Salary(-1, employee, 100, new Date(), "因为旷工"));
                }else if(sign.getStatus()==-2){
                    Salary salary=salaryService.findByEmployeeId(employee.getId());
                    salary.setMoney(100);
                    salaryService.update(salary);
                }
            }else{
                //旷工
                message="未到签到时间,不能签到";
                System.out.println(message);

            }



        }else{
            //表示今天已经签过到
            message=new String(message.getBytes("gbk"),"utf-8");
            message="上午暂未签到,下午不能签到!!";
            System.out.println(message);

        }
        message=new String(message.getBytes("gbk"),"utf-8");
        model.addAttribute("message",message);

        List<Sign> signs=signService.findAll();
        System.out.println(signs);
        model.addAttribute("signs",signs);
        return "sign";
    }

    @RequestMapping("salarys")
    String salarys(Model model){
        List<Sign> signs = signService.findAll();
        Map<Employee,Double> payRolls=new HashMap<>();
        for (Sign sign:signs) {
            if (sign.getGiven_status()==1){
                Employee employee=employeeService.findByName(sign.getUser().getUsername());
                if(!payRolls.containsKey(employee)){
                    payRolls.put(employee,200.0);
                }else{
                    payRolls.put(employee,200.0+payRolls.get(employee));

                }
            }
        }
        System.out.println(payRolls);
        model.addAttribute("payRolls",payRolls);
        return "employeeRewards";
    }
    @RequestMapping("trains")
    String trains(Model model){
        List<Train> trains = trainService.findAll();
        model.addAttribute("trains",trains);
        return "employeeTrains";
    }

}
