package com.example.demo.entity;

import java.util.Date;

public class Employee {
    private int id;
    private Dept dept=new Dept();
    private Job job=new Job();
    private String name;
    private String address;
    private String phone;
    private String email;
    private String sex;
    private Date birthday;
    private  String remark;
    private Date create_date=new Date();
    private int salary;

    public Employee() {
    }

    public Employee(int id, Dept dept, Job job, String name, String address, String phone, String email, String sex, Date birthday, String remark, Date create_date, int salary) {
        this.id = id;
        this.dept = dept;
        this.job = job;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.remark = remark;
        this.create_date = create_date;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", dept=" + dept +
                ", job=" + job +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", remark='" + remark + '\'' +
                ", create_date=" + create_date +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
