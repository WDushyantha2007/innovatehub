package com.innovatehub.user.proxy;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dto.UserResponse;
import com.innovatehub.user.service.UserService;
import com.innovatehub.user.validator.UserValidator;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserServiceProxyImpl implements UserService {

    private UserService userService;
    private UserValidator userValidator;

    public UserServiceProxyImpl(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @Override
    public void updateMember(Member member) {
        userService.updateMember(member);
    }

    @Override
    public List<Member> findAll() {
        return userService.findAll();
    }

    @Override
    public void deleteByMemberId(int MemberID) {
        userService.deleteByMemberId(MemberID);
    }

    @Override
    public Member saveMember(Member member) {
        if (!userValidator.isValid(member)) {
            return new UserResponse(member, "User is not valid", HttpStatus.BAD_REQUEST);
        }
        userService.saveMember(member);
        return new UserResponse(member, "member saved sucessfully", HttpStatus.OK);
    }
}
