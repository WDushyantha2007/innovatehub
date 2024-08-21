package com.innovatehub.user.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dto.UserResponse;
import com.innovatehub.user.service.UserService;
import com.innovatehub.user.validator.UserValidator;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserServiceProxyImpl implements UserServiceProxy {

    private UserService userService;
    private UserValidator userValidator;

    public UserServiceProxyImpl(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @Override
    public void updateMember(Member member, String tokenID)throws APISecurityException {

        if(!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        userService.updateMember(member);
    }

    @Override
    public List<Member> findAll(String tokenID)throws APISecurityException {

        if(!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        return userService.findAll();
    }

    @Override
    public void deleteByMemberId(int MemberID, String tokenID)throws APISecurityException {

        if(!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        userService.deleteByMemberId(MemberID);
    }

    @Override
    public Member saveMember(Member member, String tokenID)throws APISecurityException {

        if(!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        if (!userValidator.isValid(member)) {
            return new UserResponse(member, "User is not valid", HttpStatus.BAD_REQUEST);
        }
        userService.saveMember(member);
        return new UserResponse(member, "member saved sucessfully", HttpStatus.OK);
    }
}
