package com.uncc.ssdi.openofficeapi.controller;

import com.uncc.ssdi.openofficeapi.model.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={ "http://localhost:3000" })
@RestController
public class AuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        System.out.println("Login call");
        return new AuthenticationBean("You are authenticated");
    }
}
