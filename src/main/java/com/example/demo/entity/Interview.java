package com.example.demo.entity;

import java.util.Date;

public class Interview {
    private int id;
    private String name;
    private Date deliverDate;
    private int lookStatus;
    private  int interviewStatus;
    private Recruit recruit=new Recruit();

    public Interview() {
    }

    public Interview(int id, String name, Date deliverDate, int lookStatus, int interviewStatus, Recruit recruit) {
        this.id = id;
        this.name = name;
        this.deliverDate = deliverDate;
        this.lookStatus = lookStatus;
        this.interviewStatus = interviewStatus;
        this.recruit = recruit;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliverDate=" + deliverDate +
                ", lookStatus=" + lookStatus +
                ", interviewStatus=" + interviewStatus +
                ", recruit=" + recruit +
                '}';
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
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

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public int getLookStatus() {
        return lookStatus;
    }

    public void setLookStatus(int lookStatus) {
        this.lookStatus = lookStatus;
    }

    public int getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(int interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
