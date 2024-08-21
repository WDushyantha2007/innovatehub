package com.innovatehub.user.web;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.dto.UserResponse;
import com.innovatehub.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private UserService userServiceProxy;

    public MemberController(UserService userService) {
        this.userServiceProxy = userServiceProxy;
    }

    @GetMapping(value = "/member")
    public List<Member> allMembers() {
        return userServiceProxy.findAll();
    }

    @PostMapping(value = "/member")
    public ResponseEntity<Member> createMember(@RequestBody Member newMember) {
        try {
            UserResponse userResponse = (UserResponse) userServiceProxy.saveMember(newMember);
            return new ResponseEntity<>(userResponse, userResponse.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>(newMember, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/member/{memberId}")
    public void deleteMember(@PathVariable int memberId) {
        userServiceProxy.deleteByMemberId(memberId);
    }

    @PutMapping(value = "/member")
    public void updateMember(@RequestBody Member member) {
        userServiceProxy.updateMember(member);
    }
}
