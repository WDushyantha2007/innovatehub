package com.innovatehub.user.service;

import com.innovatehub.user.dao.Member;

import java.util.List;

public interface UserService {

    public void updateMember(Member member);

    public List<Member> findAll();

    public void deleteByMemberId(int MemberID);

    public Member saveMember(Member member);

}
