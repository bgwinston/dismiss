package org.launchcode.dismissal1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.launchcode.dismissal1.models.user;



@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public String userInfo(@SessionAttribute("user") user user ){
        System.out.println("username:" + user.getUsername());
        System.out.println("password" + user.getPassword());

        return "user";
    }
}

