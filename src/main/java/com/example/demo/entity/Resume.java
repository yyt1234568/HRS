package com.example.demo.entity;

public class Resume {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String sex;
    private int job_id;
    private int current_job;
    private String resumepage;
    private User user=new User();

    public Resume() {
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", job_id=" + job_id +
                ", current_job=" + current_job +
                ", resumepage='" + resumepage + '\'' +
                ", user=" + user +
                '}';
    }

    public Resume(int id, String name, String email, String phone, String sex, int job_id, int current_job, String resumepage, User user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.job_id = job_id;
        this.current_job = current_job;
        this.resumepage = resumepage;
        this.user = user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getCurrent_job() {
        return current_job;
    }

    public void setCurrent_job(int current_job) {
        this.current_job = current_job;
    }

    public String getResumepage() {
        return resumepage;
    }

    public void setResumepage(String resumepage) {
        this.resumepage = resumepage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
