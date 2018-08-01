package com.example.demo.entity;

public class Job {
    private int id;
    private  String name;
    private Dept dept=new Dept();

    public Job() {
    }

    public Job(int id, String name, Dept dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
