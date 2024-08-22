package com.innovatehub.user.proxy;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.user.dao.Member;

import java.util.List;

public interface UserServiceProxy {

    public void updateMember(Member member, String tokenID) throws APISecurityException;

    public List<Member> findAll(String tokenID) throws APISecurityException;

    public void deleteByMemberId(int MemberID, String tokenID) throws APISecurityException;

    public Member saveMember(Member member, String tokenID) throws APISecurityException;

}
