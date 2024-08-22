package com.innovatehub.user.service;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dao.MemberStubRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() throws Exception {
        userService = new UserServiceImpl(new MemberStubRepository());
    }

    @Test
    public void testUpdateMember() {
        userService.updateMember(new Member(1, "UT", "UT"));
        Member mem = userService.findAll().
                stream().filter(m -> m.getMemberId() == 1).findFirst().get();

        Assertions.assertEquals("UT", mem.getMemberName());
    }

    @Test
    public void testFindAllMember() {
        List<Member> memberList = userService.findAll();
        Assertions.assertEquals(2, memberList.size());
    }

    @Test
    public void testDeleteByMemberId() {
        userService.deleteByMemberId(1);
        List<Member> memberList = userService.findAll();
        Assertions.assertEquals(1, memberList.size());
    }

    @Test
    public void testSaveMember() {
        userService.saveMember(new Member(3, "UT", "UT"));
        Member mem = userService.findAll().
                stream().filter(m -> m.getMemberId() == 3).findFirst().get();
        Assertions.assertEquals("UT", mem.getMemberName());
    }
}
