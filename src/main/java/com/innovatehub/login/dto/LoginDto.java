package com.innovatehub.login.dto;

public class LoginDto {

    private int userId;

    private String bCryptPassword;

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
}
