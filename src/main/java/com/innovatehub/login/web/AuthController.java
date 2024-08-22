package com.innovatehub.login.web;

import com.innovatehub.login.dto.LoginDto;
import com.innovatehub.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private LoginService loginService;

    @Autowired
    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * Find the user with given user id and bcrypt password.
     *
     * @param loginDto
     * @return User object.
     */
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(loginService.findUserById(loginDto.getUserId(), loginDto.getbCryptPassword()),
                HttpStatus.OK);
    }
}
