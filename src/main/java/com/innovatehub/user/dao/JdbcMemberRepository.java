package com.innovatehub.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcMemberRepository implements MemberRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Update the given member details.
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        String sql = "update member set MemberName = ?, MemberUrl = ? where MemberID = ?";
        jdbcTemplate.update(sql, member.getMemberName(), member.getMemberUrl(), member.getMemberId());
    }

    /**
     * Return all members.
     * @return List of members.
     */
    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        String sql = "select MemberID,MemberName,MemberUrl from  member";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Member member = new Member();
            member.setMemberId((Integer) row.get("MemberID"));
            member.setMemberName((String) row.get("MemberName"));
            member.setMemberUrl((String) row.get("MemberUrl"));
            memberList.add(member);
        }

        return memberList;
    }

    /**
     * Delete member by given ID.
     * @param MemberID
     */
    @Override
    public void deleteByMemberId(int MemberID) {
        String sql = "delete from member where MemberID = ?";
        jdbcTemplate.update(sql, MemberID);
    }

    /**
     * Persist the given member to the database.
     * @param member
     * @return Given member.
     */
    @Override
    public Member saveMember(Member member) {
        String sql = "insert into member(MemberName,MemberUrl) values (?, ?)";
        jdbcTemplate.update(sql, member.getMemberName(), member.getMemberUrl());
        return member;
    }
}
