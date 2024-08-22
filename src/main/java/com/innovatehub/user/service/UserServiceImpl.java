package com.innovatehub.user.service;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dao.MemberRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private MemberRepository memberRepository;

    public UserServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * Update the member.
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    /**
     * Return all members.
     * @return Return all members.
     */
    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     * Delete member by id.
     * @param MemberID
     */
    @Override
    public void deleteByMemberId(int MemberID) {
        memberRepository.deleteByMemberId(MemberID);
    }

    /**
     * Persis the member.
     * @param member
     * @return Return given member.
     */
    @Override
    public Member saveMember(Member member) {
        return memberRepository.saveMember(member);
    }
}
