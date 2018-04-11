package com.p2p.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String ip;

    private String port;

    private Integer status;

    private Date lastLogin;

    public User(Integer id, String name, String password, String ip, String port, Integer status, Date lastLogin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.ip = ip;
        this.port = port;
        this.status = status;
        this.lastLogin = lastLogin;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}