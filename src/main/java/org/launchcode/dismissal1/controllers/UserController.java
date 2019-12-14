package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
@RequestMapping("/User")
public class UserController {

    @GetMapping("/info")
    public String userInfo(@SessionAttribute("User") User user ){
        System.out.println("username:" + user.getUsername());
        System.out.println("password" + user.getPassword());

        return "User";
    }
}

