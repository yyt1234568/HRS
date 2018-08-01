package com.example.demo.entity;

import java.util.Date;

public class Train {
    private int id;
    private Employee employee=new Employee();
    private Date start_time;
    private Date end_time;
    private String teach_name;
    private String class_name;
    private String address;
    private String context;

    public int getId() {
        return id;
    }

    public Train(int id, Employee employee, Date start_time, Date end_time, String teach_name, String class_name, String address, String context) {
        this.id = id;
        this.employee = employee;
        this.start_time = start_time;
        this.end_time = end_time;
        this.teach_name = teach_name;
        this.class_name = class_name;
        this.address = address;
        this.context = context;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", employee=" + employee +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", teach_name='" + teach_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

    public Train() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getTeach_name() {
        return teach_name;
    }

    public void setTeach_name(String teach_name) {
        this.teach_name = teach_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
