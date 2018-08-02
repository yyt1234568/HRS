package com.example.demo.entity;

public class PayRoll {
    private int employee_id;
    private double mooney;

    public PayRoll() {
    }

    public PayRoll(int employee_id, double mooney) {
        this.employee_id = employee_id;
        this.mooney = mooney;
    }

    @Override
    public String toString() {
        return "PayRoll{" +
                "employee_id=" + employee_id +
                ", mooney=" + mooney +
                '}';
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getMooney() {
        return mooney;
    }

    public void setMooney(double mooney) {
        this.mooney = mooney;
    }
}
