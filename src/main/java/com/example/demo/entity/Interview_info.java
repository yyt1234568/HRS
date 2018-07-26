package com.example.demo.entity;

import java.util.Date;

public class Interview_info {
    private int id;
    private Resume resume=new Resume();
    private Date view_time;
    private String address;
    private Interview interview=new Interview();

    public Interview_info(int id, Resume resume, Date view_time, String address, Interview interview) {
        this.id = id;
        this.resume = resume;
        this.view_time = view_time;
        this.address = address;
        this.interview = interview;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Interview_info() {
    }

    @Override
    public String toString() {
        return "Interview_info{" +
                "id=" + id +
                ", resume=" + resume +
                ", view_time=" + view_time +
                ", address='" + address + '\'' +
                ", interview=" + interview +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Date getView_time() {
        return view_time;
    }

    public void setView_time(Date view_time) {
        this.view_time = view_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
