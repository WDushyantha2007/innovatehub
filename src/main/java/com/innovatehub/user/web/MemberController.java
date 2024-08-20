package com.innovatehub.user.web;

import com.innovatehub.user.dao.Member;
import com.innovatehub.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private UserService userService;

    public MemberController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/member")
    public List<Member> allMembers() {
        return userService.findAll();
    }

    @PostMapping(value = "/member")
    public ResponseEntity<Member> createMember(@RequestBody Member newMember) {
        return new ResponseEntity<>(userService.saveMember(newMember), HttpStatus.OK);
    }

    @DeleteMapping(value = "/member/{memberId}")
    public void deleteMember(@PathVariable int memberId) {
        userService.deleteByMemberId(memberId);
    }

    @PutMapping(value = "/member")
    public void updateMember(@RequestBody Member member) {
        userService.updateMember(member);
    }
}
