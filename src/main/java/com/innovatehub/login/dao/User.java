package com.innovatehub.login.dao;

public class User {

    private int userId;
    private String bCryptPassword;
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getbCryptPassword() {
        return bCryptPassword;
    }

    public void setbCryptPassword(String bCryptPassword) {
        this.bCryptPassword = bCryptPassword;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
