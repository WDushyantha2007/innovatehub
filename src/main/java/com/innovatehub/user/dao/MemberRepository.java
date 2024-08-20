package com.innovatehub.user.dao;

import java.util.List;

public interface MemberRepository {

    public void updateMember(Member member);

    public List<Member> findAll();

    public void deleteByMemberId(int MemberID);

    public Member saveMember(Member member);

}
