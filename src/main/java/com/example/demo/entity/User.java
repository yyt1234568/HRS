package com.example.demo.entity;


import javax.management.relation.Role;

public class User {

    private int id;
    private String username;
    private String password;
    private String role_id;

    public User() {
    }


    public User(int id, String username, String password, String role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

}
