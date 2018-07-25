package com.example.demo.entity;

import java.util.Date;

public class Recruit {
    private int id;
    private Date createDate;
    private int salary;
    private Job job=new Job();
    private Dept dept=new Dept();
    private int count;
    private String demand;
    private String title;


    public Recruit() {
    }

    public Recruit(int id, Date createDate, int salary, Job job, Dept dept, int count, String demand, String title) {
        this.id = id;
        this.createDate = createDate;
        this.salary = salary;
        this.job = job;
        this.dept = dept;
        this.count = count;
        this.demand = demand;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", salary=" + salary +
                ", job=" + job +
                ", dept=" + dept +
                ", count=" + count +
                ", demand='" + demand + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
