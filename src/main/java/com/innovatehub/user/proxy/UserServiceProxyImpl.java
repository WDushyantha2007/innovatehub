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

    /**
     * Check user has valid security token which has access to the api.
     * If yes update the member.
     * @param member
     * @param tokenID
     * @throws APISecurityException
     */
    @Override
    public void updateMember(Member member, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        userService.updateMember(member);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes return all members.
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @Override
    public List<Member> findAll(String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        return userService.findAll();
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes delete member by Id.
     * @param MemberID
     * @param tokenID
     * @throws APISecurityException
     */
    @Override
    public void deleteByMemberId(int MemberID, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        userService.deleteByMemberId(MemberID);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes validate member.
     * If valid then save the member.
     * @param member
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @Override
    public Member saveMember(Member member, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "user")) {
            throw new APISecurityException("Unauthorized operation");
        }

        if (!userValidator.isValid(member)) {
            return new UserResponse(member, "User is not valid", HttpStatus.BAD_REQUEST);
        }
        userService.saveMember(member);
        return new UserResponse(member, "member saved sucessfully", HttpStatus.OK);
    }
}
