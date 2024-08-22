package com.innovatehub.user.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dao.MemberRepository;
import com.innovatehub.user.dao.MemberStubRepository;
import com.innovatehub.user.dto.UserResponse;
import com.innovatehub.user.service.UserServiceImpl;
import com.innovatehub.user.validator.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceProxyImplTest {

    private UserServiceProxyImpl userServiceProxy;
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() throws Exception {
        APICacheManager.clearCache();
        memberRepository = new MemberStubRepository();
        userServiceProxy = new UserServiceProxyImpl(
                new UserServiceImpl(memberRepository), new UserValidator());

    }

    @Test
    public void testUpdateMemberInvalidToken() {
        boolean isSecurity = false;
        try {
            userServiceProxy.updateMember(new Member(1, "Test", "Test"),
                    "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testUpdateMemberValidToken() {
        APICacheManager.addTokenPrevilages("12", 1);
        try {
            userServiceProxy.updateMember(new Member(1, "TestU", "TestU"), "12");
        } catch (APISecurityException e) {
        }

        Member member = memberRepository.findAll()
                .stream().filter(m -> m.getMemberId() == 1).findFirst().get();

        Assertions.assertEquals("TestU", member.getMemberName());

    }

    @Test
    public void testFindAllMemberInvalidToken() {

        boolean isSecurity = false;
        try {
            userServiceProxy.findAll("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testFindAllMemberValidToken() {

        boolean isSecurity = false;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            userServiceProxy.findAll("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(false, isSecurity);
    }

    @Test
    public void testDeleteMemberInvalidToken() {

        boolean isSecurity = false;
        try {
            userServiceProxy.deleteByMemberId(1, "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testDeleteMemberValidToken() {
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            userServiceProxy.deleteByMemberId(1, "12");
        } catch (APISecurityException e) {
        }

        List<Member> memberList = memberRepository.findAll();
        Assertions.assertEquals(1, memberList.size());
    }

    @Test
    public void testSaveMemberInvalidToken() {

        boolean isSecurity = false;
        try {
            userServiceProxy.saveMember(new Member(1, "Test", "Test"),
                    "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testSaveMemberValidTokenInvalidMember() {

        Member memberResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            memberResponse = userServiceProxy.saveMember(new Member(1, "", "Test"),
                    "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("User is not valid", ((UserResponse) memberResponse).getMessage());
    }


    @Test
    public void testUpdateMemberValidTokenValidMember() {

        Member memberResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            memberResponse = userServiceProxy.saveMember(new Member(1, "Test", "Test"),
                    "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("member saved sucessfully", ((UserResponse) memberResponse).getMessage());

    }

}
