package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



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
    String deptinfo() {


        return "dept_info";
    }

    @RequestMapping("deptdata")
    @ResponseBody
    public List<Job> deptdata() {


        return "dept_info";
    }

}
