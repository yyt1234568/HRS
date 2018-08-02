package com.example.demo.entity;

import java.util.Date;

public class Sign {
    private int id;
    private User user=new User();
    private Date start_date;
    private Date end_date;
    private int status;
    private int given_status;

    public Sign() {
    }

    public Sign(int id, User user, Date start_date, Date end_date, int status) {
        this.id = id;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        given_status=0;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", user=" + user +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", status=" + status +
                ", given_status=" + given_status +
                '}';
    }

    public Sign(int id, User user, Date start_date, Date end_date, int status, int given_status) {
        this.id = id;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.given_status = given_status;

    }

    public int getGiven_status() {
        return given_status;
    }

    public void setGiven_status(int given_status) {
        this.given_status = given_status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
