package com.innovatehub.user.dto;

import com.innovatehub.user.dao.Member;
import org.springframework.http.HttpStatus;

public class UserResponse extends Member {
    private String message;
    private HttpStatus statusCode;

    public UserResponse(Member member, String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        setMemberId(member.getMemberId());
        setMemberName(member.getMemberName());
        setMemberUrl(member.getMemberUrl());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
