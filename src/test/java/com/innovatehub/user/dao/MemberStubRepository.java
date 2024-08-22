package com.innovatehub.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberStubRepository implements MemberRepository {

    private Map<Integer, Member> memberMap = new HashMap<>();

    public MemberStubRepository() {
        memberMap.put(1, new Member(1, "Test", "Test"));
        memberMap.put(2, new Member(2, "Test2", "Test2"));
    }

    @Override
    public void updateMember(Member member) {
        memberMap.put(member.getMemberId(), member);
    }

    @Override
    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }

    @Override
    public void deleteByMemberId(int MemberID) {
        memberMap.remove(MemberID);
    }

    @Override
    public Member saveMember(Member member) {
        memberMap.put(member.getMemberId(), member);
        return memberMap.get(member.getMemberId());
    }
}
