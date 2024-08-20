package com.innovatehub.user.service;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dao.MemberRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private MemberRepository memberRepository;

    public UserServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteByMemberId(int MemberID) {
        memberRepository.deleteByMemberId(MemberID);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.saveMember(member);
    }
}
