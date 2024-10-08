package com.innovatehub.user.web;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dto.UserResponse;
import com.innovatehub.user.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private UserServiceProxy userServiceProxy;

    @Autowired
    public MemberController(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    /**
     * Return all members with 200 status.
     * If token is invalid return 401.
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @GetMapping(value = "/member")
    public List<Member> allMembers(@RequestHeader("tokenID") String tokenID) throws APISecurityException {
        return userServiceProxy.findAll(tokenID);
    }

    /**
     * Save the member. If security error comes return 401.
     * If member is invalid return 400 with given order.
     * If member is valid return 200 with valid order.
     * If security token is invalid return 401 error.
     * @param newMember
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @PostMapping(value = "/member")
    public ResponseEntity<Member> createMember(@RequestBody Member newMember, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        try {
            UserResponse userResponse = (UserResponse) userServiceProxy.saveMember(newMember, tokenID);
            return new ResponseEntity<>(userResponse, userResponse.getStatusCode());
        } catch (APISecurityException e) {
            throw new APISecurityException("Unauthorized operation");
        } catch (Exception e) {
            return new ResponseEntity<>(newMember, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete the given member with 200 status.
     * If token is invalid return 401.
     * @param memberId
     * @param tokenID
     * @throws APISecurityException
     */
    @DeleteMapping(value = "/member/{memberId}")
    public void deleteMember(@PathVariable int memberId, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        userServiceProxy.deleteByMemberId(memberId, tokenID);
    }

    /**
     * Update the given member with 200 status.
     * If token is invalid return 401.
     * @param member
     * @param tokenID
     * @throws APISecurityException
     */
    @PutMapping(value = "/member")
    public void updateMember(@RequestBody Member member, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        userServiceProxy.updateMember(member, tokenID);
    }

    /**
     * If security error comes return 401.
     * @param ex
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }
}
