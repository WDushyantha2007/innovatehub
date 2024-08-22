package com.innovatehub.user.dao;

public class Member {
    private int memberId;

    private String memberName;

    private String memberUrl;

    public Member() {

    }

    public Member(int memberId, String memberName, String memberUrl) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberUrl = memberUrl;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(String memberUrl) {
        this.memberUrl = memberUrl;
    }
}
