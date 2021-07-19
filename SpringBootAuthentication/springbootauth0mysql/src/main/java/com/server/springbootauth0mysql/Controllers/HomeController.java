package com.server.springbootauth0mysql.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String homeControllerResponse() {
        return "springbootauth0mysql";
    }
}
