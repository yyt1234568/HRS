package com.example.demo.entity;

import java.util.Date;

public class Salary {
    private int id;
    private Employee employee=new Employee();
    private double money;
    private Date time;
    private String cause;
    public Salary() {
    }

    public Salary(int id, Employee employee, double money, Date time, String cause) {
        this.id = id;
        this.employee = employee;
        this.money = money;
        this.time = time;
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", employee=" + employee +
                ", money=" + money +
                ", time=" + time +
                ", cause='" + cause + '\'' +
                '}';
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getId() {
        return id;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
