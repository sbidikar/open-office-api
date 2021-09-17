package com.uncc.ssdi.openofficeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenOfficeController {

    @GetMapping("/getMessage")
    public String getMessage(){
        return "Hello from Open office";
    }
}
