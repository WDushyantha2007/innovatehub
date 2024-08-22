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

    @GetMapping(value = "/member")
    public List<Member> allMembers(@RequestHeader("tokenID") String tokenID) throws APISecurityException {
        return userServiceProxy.findAll(tokenID);
    }

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

    @DeleteMapping(value = "/member/{memberId}")
    public void deleteMember(@PathVariable int memberId, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        userServiceProxy.deleteByMemberId(memberId, tokenID);
    }

    @PutMapping(value = "/member")
    public void updateMember(@RequestBody Member member, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        userServiceProxy.updateMember(member, tokenID);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }
}
